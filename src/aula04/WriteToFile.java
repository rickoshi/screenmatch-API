package aula04;

import java.io.FileWriter;
import java.io.IOException;

public class WriteToFile {
    public static void main(String[] args) {
        // 1. Crie um programa em Java que escreva a seguinte mensagem em um arquivo chamado "arquivo.txt":
        // "Conteúdo a ser gravado no arquivo." Utilize as classes do pacote java.io.
        try (FileWriter fileWriter = new FileWriter("src\\aula04\\arquivo.txt")) {
            fileWriter.write("Conteúdo a ser gravado no arquivo.");
            System.out.println("Dados gravados com sucesso.");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
