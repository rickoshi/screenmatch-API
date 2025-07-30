package aula03;

import java.util.Scanner;

public class ExercicioDivisao {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite o numerador: ");
        int numerador = scanner.nextInt();
        System.out.println("Digite o denominador: ");
        int denominador = scanner.nextInt();

        try {
            int resultado = numerador / denominador;
            System.out.println("O resultado é: " + resultado);
        } catch (ArithmeticException e) {
            System.out.println("Divisão por 0 inválida");
        }
    }
}
