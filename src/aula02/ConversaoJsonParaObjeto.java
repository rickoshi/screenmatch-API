package aula02;

import com.google.gson.Gson;

public class ConversaoJsonParaObjeto {
    public static void main(String[] args) {
        String jsonPessoa = "{\"nome\":\"Rodrigo\",\"idade\":20,\"cidade\":\"Brasília\"}";
        System.out.println("Json da Pessoa");
        System.out.println(jsonPessoa);
        System.out.println();
        Gson gson = new Gson();
        Pessoa pessoa = gson.fromJson(jsonPessoa, Pessoa.class);
        System.out.println("Objeto Pessoa");
        System.out.println(pessoa);
    }
}
