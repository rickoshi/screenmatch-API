package buscador;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;

public class GeradorDeArquivo {

    public void salvaJson(Endereco endereco) throws IOException {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        String nomeArquivo = "src\\buscador\\" + endereco.cep() + ".json";

        FileWriter escrita = new FileWriter(nomeArquivo);
        escrita.write(gson.toJson(endereco));
        escrita.close();
    }
}
