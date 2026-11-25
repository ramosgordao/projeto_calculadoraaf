package calculadora;

/**
 * Calculadora de operações matemáticas básicas.
 * @author Aluno
 * @version 1.0
 */
public class Calculadora {

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
        if ("+".equals(op)) {
            return (double) a + b;
        } else if ("-".equals(op)) {
            return (double) a - b;
        } else if ("*".equals(op)) {
            return (double) a * b;
        } else if ("/".equals(op)) {
            // Não permite dividir por zero.
            if (b == 0) {
                throw new ArithmeticException("Não é possível dividir por zero.");
            }
            // Converte para double para permitir resultados com casas decimais.
            return (double) a / b;
        } else {
            throw new IllegalArgumentException("Operação inválida.");
        }
    }
}
