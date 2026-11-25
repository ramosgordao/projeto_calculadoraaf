package calculadora;

import java.util.Scanner;

/**
 * Programa que permite utilizar a calculadora pelo terminal.
 * @author Aluno
 * @version 1.0
 */
public class Main {

    /**
     * Solicita números e operações até que o usuário escolha sair.
     * @param args argumentos da linha de comando (não utilizados)
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Calculadora calculadora = new Calculadora();

        System.out.println("=== Calculadora FinançApp ===");

        while (true) {
            System.out.print("Operação (+, -, *, /) ou sair: ");
            if (!scanner.hasNextLine()) {
                break;
            }
            String op = scanner.nextLine().trim();
            if (op.equalsIgnoreCase("sair")) {
                break;
            }

            try {
                System.out.print("Primeiro número inteiro: ");
                if (!scanner.hasNextLine()) {
                    break;
                }
                int a = Integer.parseInt(scanner.nextLine().trim());
                System.out.print("Segundo número inteiro: ");
                if (!scanner.hasNextLine()) {
                    break;
                }
                int b = Integer.parseInt(scanner.nextLine().trim());

                double resultado = calculadora.calc(a, b, op);
                System.out.println("Resultado: " + resultado);
            } catch (NumberFormatException e) {
                System.out.println("Erro: digite números inteiros válidos.");
            } catch (ArithmeticException e) {
                System.out.println("Erro: " + e.getMessage());
            } catch (IllegalArgumentException e) {
                System.out.println("Erro: " + e.getMessage());
            }
            // Mesmo após um erro, o menu é exibido novamente.
            System.out.println();
        }

        scanner.close();
        System.out.println("Programa encerrado.");
    }
}
