import java.util.Scanner;

public class EX7 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Insira um número: ");
        int numero = scanner.nextInt();

        String mensagem = (numero > 10) ? "Maior que 10!" : "Não é maior que 10!";
        System.out.println(mensagem);

        scanner.close();
    }
}
/* Análise de Execução:

| Passo | Descrição                                   | numero | mensagem               |                        Cálculo                                   | Resultado                     |
|-------|---------------------------------------------|--------|------------------------|------------------------------------------------------------------|-------------------------------|
| 1     | Entrada: Insira um número                   | 15     |                        |                                                                  |                               |
| 2     | Verificar se o número é maior que 10        | 15     |                        | `(numero > 10) ? "Maior que 10!" : "Não é maior que 10!"`        | "Maior que 10!"               |
| 3     | Mostrar a mensagem                          | 15     | "Maior que 10!"        |                                                                  | "Maior que 10!"               |

*/
