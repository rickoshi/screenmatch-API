package br.com.alura.screenmatch.principal;

import br.com.alura.screenmatch.exceptions.ErroDeConversaoDeAnoException;
import br.com.alura.screenmatch.modelos.Titulo;
import br.com.alura.screenmatch.modelos.TituloOmdb;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PrincipalComBusca {
    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner leitura = new Scanner(System.in);
        String busca = "";
        List<Titulo> titulos = new ArrayList<>();
        Gson gsonCapitalizado = new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
                .setPrettyPrinting()
                .create();

        while (!busca.equalsIgnoreCase("sair")) {
            System.out.println("Digite um filme para busca: ");
            busca = leitura.nextLine();

            if (busca.equalsIgnoreCase("sair")) {
                break;
            }

            String chave = "e8cde3d4";
            String endereco = "https://www.omdbapi.com/?t=" + busca.replace(" ", "+") + "&apikey=" + chave;

            try {
                HttpClient client = HttpClient.newHttpClient();
                HttpRequest request = HttpRequest.newBuilder().uri(URI.create(endereco)).build();
                HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

                String json = response.body();
                System.out.println("Título Json");
                System.out.println(json);
                System.out.println();

                // Aplicamos um gson com anotação @SerializedName na classe Titulo para permitir o mapeamento das variáveis
                // Por possuir apenas uma maneira de se mapear a variável, não é muito recomendável usá-la
//            Gson gson = new Gson();
//            Titulo meuTitulo = gson.fromJson(json, Titulo.class);
//            System.out.println("Título com anotação @SerializedName");
//            System.out.println(meuTitulo);
//            System.out.println();

                // Criando um novo builder de Gson para permitir mudar a politíca de nomenclatura
                // Utilizamos o record TituloOmdb para permitir a tranferência de dados sem a necessidade de alterar
                // a classe Titulo, ou de criar uma classe específica para objetos de tranferência de dados (DTO)
                TituloOmdb meuTituloOmdb = gsonCapitalizado.fromJson(json, TituloOmdb.class);
                System.out.println("Título Omdb");
                System.out.println(meuTituloOmdb);
                System.out.println();

                // Para termos um objeto Filme/Titulo, que possui métodos próprios, convertemos um DTO para a classe específica
                // Podemos instanciar o objeto com os parâmetros de atributos dentro do próprio record, algo como:
                // Titulo meuTituloConvertido = new Titulo(meuTituloOmdb.title(), meuTituloOmdb.year(), ...);

                // Porém, para melhor organização, validação dos dados, entre outros; podemos criar um novo construtor
                Titulo meuTituloConvertido = new Titulo(meuTituloOmdb);
                System.out.println("Título convertido");
                System.out.println(meuTituloConvertido);

//                FileWriter escrita = new FileWriter("filmes.txt");
//                escrita.write(meuTituloConvertido.toString());
//                escrita.close();

                // Adiciona o objeto de Título para a arrayLista titulos
                titulos.add(meuTituloConvertido);

            } catch (NumberFormatException e) {
                System.out.println("Aconteceu um erro: ");
                System.out.println(e.getMessage());
            } catch (IllegalArgumentException e) {
                System.out.println("Algum erro de argumento na busca, verifique o endereço");
            } catch (ErroDeConversaoDeAnoException e) {
                System.out.println(e.getMessage());
            }
        }
        System.out.println(titulos);

        FileWriter escrita = new FileWriter("filmes.json");
        escrita.write(gsonCapitalizado.toJson(titulos));
        escrita.close();

        System.out.println("O programa finalizou corretamente");
    }
}
