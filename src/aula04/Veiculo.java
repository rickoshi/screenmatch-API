package aula04;

import com.google.gson.Gson;

public class Veiculo {
    private String marca;
    private String modelo;
    private int anoDeFabricacao;
    private double preco;

    public Veiculo(String marca, String modelo, int anoDeFabricacao, double preco) {
        this.marca = marca;
        this.modelo = modelo;
        this.anoDeFabricacao = anoDeFabricacao;
        this.preco = preco;
    }

    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    public int getAnoDeFabricacao() {
        return anoDeFabricacao;
    }

    public double getPreco() {
        return preco;
    }

    @Override
    public String toString() {
        return "Veiculo{" +
                "marca='" + marca + '\'' +
                ", modelo='" + modelo + '\'' +
                ", anoDeFabricacao=" + anoDeFabricacao +
                ", preco=" + preco +
                '}';
    }


    public static void main(String[] args) {
        // 4. Defina uma classe chamada Veiculo com os atributos necessários.
        // Em seguida, crie um programa que instancia um objeto Veiculo,
        // serializa esse objeto para JSON usando a biblioteca Gson e imprime o resultado.
        Veiculo veiculo = new Veiculo("Toyota", "Corolla", 2022, 80000.00);
        System.out.println("Objeto Veiculo: ");
        System.out.println(veiculo);
        System.out.println();

        Gson gson = new Gson();
        String veiculoJson = gson.toJson(veiculo);
        System.out.println("Json Veiculo: ");
        System.out.println(veiculoJson);
    }
}
