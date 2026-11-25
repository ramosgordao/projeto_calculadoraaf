package calculadora;

/**
 * Testes unitários simples da classe Calculadora, sem bibliotecas externas.
 * @author Aluno
 * @version 1.0
 */
public class TesteCalculadora {

    /** Quantidade de testes aprovados. */
    private static int aprovados = 0;

    /** Quantidade de testes reprovados. */
    private static int reprovados = 0;

    /**
     * Executa os testes e exibe os resultados.
     * @param args argumentos da linha de comando (não utilizados)
     * @throws AssertionError quando algum teste falhar
     */
    public static void main(String[] args) {
        Calculadora calculadora = new Calculadora();
        aprovados = 0;
        reprovados = 0;

        System.out.println("=== TESTES DA CALCULADORA ===");
        testarOperacao(calculadora, "Soma", 10, 5, "+", 15);
        testarOperacao(calculadora, "Subtração", 10, 5, "-", 5);
        testarOperacao(calculadora, "Multiplicação", 10, 5, "*", 50);
        testarOperacao(calculadora, "Divisão", 10, 5, "/", 2);
        testarErro(calculadora, "Divisão por zero", 10, 0, "/",
                "ArithmeticException: Não é possível dividir por zero.");
        testarErro(calculadora, "Operação inválida", 10, 5, "%",
                "IllegalArgumentException: Operação inválida.");
        testarOperacao(calculadora, "Divisão decimal", 5, 2, "/", 2.5);

        System.out.println("\nAprovados: " + aprovados + " | Reprovados: " + reprovados);
        if (reprovados > 0) {
            throw new AssertionError("Existem testes reprovados.");
        }
    }

    /**
     * Compara o resultado numérico obtido com o esperado.
     * @param calculadora objeto que será testado
     * @param nome nome do teste
     * @param a primeiro número
     * @param b segundo número
     * @param op operador
     * @param esperado resultado esperado
     */
    private static void testarOperacao(Calculadora calculadora, String nome,
            int a, int b, String op, double esperado) {
        System.out.println("\n" + nome + " | Entrada: " + a + " " + op + " " + b);
        System.out.println("Esperado: " + esperado);
        try {
            double obtido = calculadora.calc(a, b, op);
            System.out.println("Obtido: " + obtido);
            verificar(esperado == obtido);
        } catch (Exception e) {
            System.out.println("Obtido: " + e);
            verificar(false);
        }
    }

    /**
     * Confere se uma entrada inválida gera a exceção e a mensagem esperadas.
     * @param calculadora objeto que será testado
     * @param nome nome do teste
     * @param a primeiro número
     * @param b segundo número
     * @param op operador
     * @param esperado tipo e mensagem da exceção esperada
     */
    private static void testarErro(Calculadora calculadora, String nome,
            int a, int b, String op, String esperado) {
        System.out.println("\n" + nome + " | Entrada: " + a + " " + op + " " + b);
        System.out.println("Esperado: " + esperado);
        String obtido;
        try {
            obtido = "Resultado: " + calculadora.calc(a, b, op);
        } catch (Exception e) {
            obtido = e.getClass().getSimpleName() + ": " + e.getMessage();
        }
        System.out.println("Obtido: " + obtido);
        verificar(esperado.equals(obtido));
    }

    /**
     * Registra se o teste passou ou falhou.
     * @param passou verdadeiro se o resultado estiver correto
     */
    private static void verificar(boolean passou) {
        if (passou) {
            aprovados++;
            System.out.println("APROVADO");
        } else {
            reprovados++;
            System.out.println("REPROVADO");
        }
    }
}
