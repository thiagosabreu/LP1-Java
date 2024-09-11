import java.util.Scanner;

public class EX3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Informe o seu salário mensal: ");
        double salarioMensal = scanner.nextDouble();

        System.out.print("Informe o percentual de reajuste: ");
        double percentualReajuste = scanner.nextDouble();

        double salarioAjustado = salarioMensal + (salarioMensal * percentualReajuste / 100);
        System.out.println("Seu novo salário é R$: " + salarioAjustado);

        scanner.close();
    }
}
/* Análise de Execução:

| Passo | Descrição                                  | salarioMensal | percentualReajuste | salarioAjustado |                    Cálculo                                   |            Resultado              |
|-------|--------------------------------------------|---------------|-------------------|-----------------|-------------------------------------------------------------|-----------------------------------|
| 1     | Entrada: Informe o seu salário mensal      | 3000          |                   |                 |                                                             |                                   |
| 2     | Entrada: Informe o percentual de reajuste  | 3000          | 10                |                 |                                                             |                                   |
| 3     | Calcular o valor do reajuste               | 3000          | 10                |                 | `salarioMensal * percentualReajuste`                        | 3000 * 10 = 30000                 |
| 4     | Dividir o valor do reajuste por 100        | 3000          | 10                |                 | `30000 / 100`                                               | 30000 / 100 = 300.0               |
| 5     | Calcular o novo salário                    | 3000          | 10                | 3300.0          | `salarioMensal + (salarioMensal * percentualReajuste / 100)`| 3000 + 300 = 3300.0               |
| 6     | Exibir o novo salário                      | 3000          | 10                | 3300.0          |                                                             | "Seu novo salário é R$: 3300.0"   |

*/
