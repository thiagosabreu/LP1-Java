import java.util.Scanner;

public class EX8 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Informe um número: ");
        int numero = scanner.nextInt();

        if (numero >= 0) {
            System.out.println("O número é positivo.");
        } else {
            System.out.println("O número é negativo.");
        }

        scanner.close();
    }
}
/* Análise de Execução:

| Passo | Descrição                             | numero | Condição (numero >= 0) | Resultado           | 
|-------|---------------------------------------|--------|------------------------|---------------------|
| 1     | Entrada: Informe um número            | 5      | true                   | "O número é positivo." | 
| 2     | Entrada: Informe um número            | -3     | false                  | "O número é negativo." |
| 3     | Entrada: Informe um número            | 0      | true                   | "O número é positivo." |

*/

