package calculadora;

/**
 * Calculadora de operações matemáticas básicas.
 * Versão refatorada com métodos separados para cada operação.
 * @author Aluno
 * @version 2.0
 */
public class Calculadora {

    /** Cria uma calculadora. */
    public Calculadora() {
    }

    /**
     * Escolhe e executa uma operação entre dois números inteiros.
     * @param a primeiro número
     * @param b segundo número
     * @param op operador matemático (+, -, * ou /)
     * @return resultado da operação
     * @throws IllegalArgumentException se a operação for inválida
     * @throws ArithmeticException se houver divisão por zero
     */
    public double calc(int a, int b, String op) {
        if (op == null) {
            throw new IllegalArgumentException("Operação inválida.");
        }

        // O switch deixa a escolha da operação mais organizada.
        switch (op) {
            case "+":
                return somar(a, b);
            case "-":
                return subtrair(a, b);
            case "*":
                return multiplicar(a, b);
            case "/":
                return dividir(a, b);
            default:
                throw new IllegalArgumentException("Operação inválida.");
        }
    }

    /**
     * Soma dois números.
     * @param primeiro primeiro número
     * @param segundo segundo número
     * @return soma dos números
     */
    private double somar(int primeiro, int segundo) {
        return (double) primeiro + segundo;
    }

    /**
     * Subtrai o segundo número do primeiro.
     * @param primeiro primeiro número
     * @param segundo segundo número
     * @return diferença dos números
     */
    private double subtrair(int primeiro, int segundo) {
        return (double) primeiro - segundo;
    }

    /**
     * Multiplica dois números.
     * @param primeiro primeiro número
     * @param segundo segundo número
     * @return produto dos números
     */
    private double multiplicar(int primeiro, int segundo) {
        return (double) primeiro * segundo;
    }

    /**
     * Divide o primeiro número pelo segundo.
     * @param primeiro dividendo
     * @param segundo divisor
     * @return resultado da divisão
     * @throws ArithmeticException se o divisor for zero
     */
    private double dividir(int primeiro, int segundo) {
        if (segundo == 0) {
            throw new ArithmeticException("Não é possível dividir por zero.");
        }
        return (double) primeiro / segundo;
    }
}
