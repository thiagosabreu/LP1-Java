import java.util.Scanner;

public class EX4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Informe o custo de fábrica: ");
        double custoFabrica = scanner.nextDouble();

        double valorDistribuidor = custoFabrica * 0.28;
        double valorImpostos = custoFabrica * 0.45;
        double precoFinalConsumidor = custoFabrica + valorDistribuidor + valorImpostos;

        System.out.println("O preço final ao consumidor é R$: " + precoFinalConsumidor);

        scanner.close();
    }
}

/* Análise de Execução:

| Passo | Descrição                                  | custoFabrica | valorDistribuidor | valorImpostos | precoFinalConsumidor |                    Cálculo                                   |        Resultado                  |
|-------|--------------------------------------------|--------------|-------------------|---------------|----------------------|-------------------------------------------------------------|-----------------------------------|
| 1     | Entrada: Informe o custo de fábrica        | 5000         |                   |               |                      |                                                             |                                   |
| 2     | Calcular o valor do distribuidor           | 5000         | 1400.0            |               |                      | `custoFabrica * 0.28`                                       | 5000 * 0.28 = 1400.0              |
| 3     | Calcular o valor dos impostos              | 5000         | 1400.0            | 2250.0        |                      | `custoFabrica * 0.45`                                       | 5000 * 0.45 = 2250.0              |
| 4     | Calcular o preço final ao consumidor       | 5000         | 1400.0            | 2250.0        | 8650.0               | `custoFabrica + valorDistribuidor + valorImpostos`          | 5000 + 1400 + 2250 = 8650.0       |
| 5     | Exibir o preço final                       | 5000         | 1400.0            | 2250.0        | 8650.0               |                                                             | "O preço final ao consumidor é R$: 8650.0"|

*/
