package calculadora;

/**
 * Calculadora de operações matemáticas básicas.
 * @author Gabriel Chinaglia 251064
 * @version 1.0
 */
public class Calculadora {

    /** Cria uma calculadora. */
    public Calculadora() {
    }

    /**
     * Realiza uma operação entre dois números inteiros.
     * @param a primeiro número
     * @param b segundo número
     * @param op operador matemático (+, -, * ou /)
     * @return resultado da operação
     * @throws IllegalArgumentException se a operação for inválida
     * @throws ArithmeticException se houver divisão por zero
     */
    public double calc(int a, int b, String op) {
        switch (op) {
            case "+" -> {
                return (double) a + b;
            }
            case "-" -> {
                return (double) a - b;
            }
            case "*" -> {
                return (double) a * b;
            }
            case "/" -> {
                if (b == 0) {
                    throw new ArithmeticException("Não é possível dividir por zero.");
                }
                return (double) a / b;
            }
            default -> throw new IllegalArgumentException("Operação inválida.");
        }
    }
}

// * @author Gabriel Chinaglia 251064