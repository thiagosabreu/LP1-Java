import java.util.Scanner;

public class EX9 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Informe a quantidade de maçãs: ");
        int quantidadeMacas = scanner.nextInt();

        if (quantidadeMacas >= 12) {
            int custoMacas = quantidadeMacas * 1;
            System.out.println("O custo total das maçãs é R$: " + custoMacas);
        } else {
            double custoMacas = quantidadeMacas * 1.3;
            System.out.println("O custo total das maçãs é R$: " + custoMacas);
        }

        scanner.close();
    }
}
/* Análise de Execução:

| Passo | Descrição                               | quantidadeMacas | Condição (quantidadeMacas >= 12) | Resultado                                |
|-------|-----------------------------------------|-----------------|----------------------------------|------------------------------------------|
| 1     | Entrada: Informe a quantidade de maçãs  | 15              | true                             | "O custo total das maçãs é R$: 15"       |
| 2     | Entrada: Informe a quantidade de maçãs  | 10              | false                            | "O custo total das maçãs é R$: 13.0"     |
| 3     | Entrada: Informe a quantidade de maçãs  | 12              | true                             | "O custo total das maçãs é R$: 12"       |

*/
