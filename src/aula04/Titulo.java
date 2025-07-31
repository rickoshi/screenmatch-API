package aula04;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Titulo {
    private String nome;
    private int anoDeLancamento;
    private int duracaoEmMinutos;

    public Titulo(String nome, int anoDeLancamento, int duracaoEmMinutos) {
        this.nome = nome;
        this.anoDeLancamento = anoDeLancamento;
        this.duracaoEmMinutos = duracaoEmMinutos;
    }

    public int getDuracaoEmMinutos() {
        return duracaoEmMinutos;
    }

    public int getAnoDeLancamento() {
        return anoDeLancamento;
    }

    public String getNome() {
        return nome;
    }

    @Override
    public String toString() {
        return "Titulo{" +
                "nome='" + nome + '\'' +
                ", anoDeLancamento=" + anoDeLancamento +
                ", duracaoEmMinutos=" + duracaoEmMinutos +
                '}';
    }


    public static void main(String[] args) {
        Titulo titulo = new Titulo("Matrix", 1999, 136);
        System.out.println("Objeto Titulo: ");
        System.out.println(titulo);
        System.out.println();

        // 2. Defina uma classe chamada Titulo com os atributos necessários.
        // Em seguida, crie um programa que instancia um objeto Titulo,
        // serializa esse objeto para JSON usando a biblioteca Gson e imprime o resultado.
        Gson gson = new Gson();
        String tituloJson = gson.toJson(titulo);
        System.out.println("Json Titulo: ");
        System.out.println(tituloJson);
        System.out.println();

        // 3. Modifique o programa anterior para que o JSON gerado seja formatado de maneira mais elegante.
        // Utilize o method setPrettyPrinting para alcançar esse resultado.
        Gson gsonElegante = new GsonBuilder().setPrettyPrinting().create();
        String tituloJsonElegante = gsonElegante.toJson(titulo);
        System.out.println("Json Elegante Titulo");
        System.out.println(tituloJsonElegante);
    }
}
