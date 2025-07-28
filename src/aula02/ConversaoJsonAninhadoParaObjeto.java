package aula02;

import com.google.gson.Gson;

public class ConversaoJsonAninhadoParaObjeto {
    public static void main(String[] args) {
        String jsonLivro = "{\"titulo\":\"Aventuras do Java\",\"autor\":\"Akemi\",\"" +
                "editora\":{\"nome\":\"TechBooks\",\"cidade\":\"São Paulo\"}}";
        System.out.println("Json do Livro");
        System.out.println(jsonLivro);
        System.out.println();
        Gson gson = new Gson();
        Livro livro = gson.fromJson(jsonLivro, Livro.class);
        System.out.println("Objeto Livro");
        System.out.println(livro);
    }
}
