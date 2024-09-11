import java.util.Scanner;

public class EX5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Informe o número de carros vendidos: ");
        double quantidadeCarrosVendidos = scanner.nextDouble();

        System.out.print("Informe o valor total das vendas: ");
        double valorTotalVendas = scanner.nextDouble();

        System.out.print("Informe o seu salário base: ");
        double salarioBase = scanner.nextDouble();

        System.out.print("Informe o valor da comissão fixa por carro vendido: ");
        double comissaoPorCarro = scanner.nextDouble();

        double salarioFinalVendedor = salarioBase + (quantidadeCarrosVendidos * comissaoPorCarro) + (valorTotalVendas * 0.05);
        System.out.println("O salário final do vendedor é R$: " + salarioFinalVendedor);

        scanner.close();
    }
}
/* Análise de Execução:

| Passo | Descrição                                                | quantidadeCarrosVendidos | valorTotalVendas | salarioBase | comissaoPorCarro | salarioFinalVendedor |                       Cálculo                                | Resultado                           |
|-------|----------------------------------------------------------|--------------------------|------------------|-------------|------------------|----------------------|--------------------------------------------------------------|-------------------------------------|
| 1     | Entrada: Informe o número de carros vendidos             | 10                       |                  |             |                  |                      |                                                              |                                     |
| 2     | Entrada: Informe o valor total das vendas                | 10                       | 100000           |             |                  |                      |                                                              |                                     |
| 3     | Entrada: Informe o seu salário base                      | 10                       | 100000           | 2000        |                  |                      |                                                              |                                     |
| 4     | Entrada: Informe o valor da comissão fixa por carro      | 10                       | 100000           | 2000        | 500              |                      |                                                              |                                     |
| 5     | Calcular o salário final do vendedor                     | 10                       | 100000           | 2000        | 500              | 9500.0               | `salarioBase + (quantidadeCarrosVendidos * comissaoPorCarro) + (valorTotalVendas * 0.05)` | 2000 + (10 * 500) + (100000 * 0.05) = 9500.0 |
| 6     | Exibir o salário final                                   | 10                       | 100000           | 2000        | 500              | 9500.0               |                                                              | "O salário final do vendedor é R$: 9500.0"  |

*/
