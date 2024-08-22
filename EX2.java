import java.util.Scanner;

public class EX2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Informe o número total de eleitores: ");
        int totalEleitores = scanner.nextInt();

        System.out.print("Informe o número de votos brancos: ");
        int votosBrancos = scanner.nextInt();

        System.out.print("Informe o número de votos nulos: ");
        int votosNulos = scanner.nextInt();

        System.out.print("Informe o número de votos válidos: ");
        int votosValidos = scanner.nextInt();

        double percentualBrancos = (double) votosBrancos / totalEleitores * 100;
        double percentualNulos = (double) votosNulos / totalEleitores * 100;
        double percentualValidos = (double) votosValidos / totalEleitores * 100;

        System.out.println("Percentual de votos brancos: " + percentualBrancos + "%");
        System.out.println("Percentual de votos nulos: " + percentualNulos + "%");
        System.out.println("Percentual de votos válidos: " + percentualValidos + "%");

        scanner.close();
    }
}

/* Análise de Execução:

| Passo | Descrição                                  | totalEleitores | votosBrancos | votosNulos | votosValidos | percentualBrancos | percentualNulos | percentualValidos |                    Cálculo                      |        Resultado           |
|-------|--------------------------------------------|----------------|--------------|------------|--------------|-------------------|-----------------|-------------------|-------------------------------------------------|----------------------------|
| 1     | Entrada: Número total de eleitores         | 1000           |              |            |              |                   |                 |                   |                                                 |                            |
| 2     | Entrada: Número de votos brancos           | 1000           | 200          |            |              |                   |                 |                   |                                                 |                            |
| 3     | Entrada: Número de votos nulos             | 1000           | 200          | 100        |              |                   |                 |                   |                                                 |                            |
| 4     | Entrada: Número de votos válidos           | 1000           | 200          | 100        | 700          |                   |                 |                   |                                                 |                            |
| 5     | Calcular o percentual de votos brancos     | 1000           | 200          | 100        | 700          | 20.0%             |                 |                   | `(votosBrancos / totalEleitores) * 100`         | 20.0%                      |
| 6     | Calcular o percentual de votos nulos       | 1000           | 200          | 100        | 700          | 20.0%             | 10.0%           |                   | `(votosNulos / totalEleitores) * 100`           | 10.0%                      |
| 7     | Calcular o percentual de votos válidos     | 1000           | 200          | 100        | 700          | 20.0%             | 10.0%           | 70.0%             | `(votosValidos / totalEleitores) * 100`         | 70.0%                      |
| 8     | Exibir o percentual de votos brancos       | 1000           | 200          | 100        | 700          | 20.0%             | 10.0%           | 70.0%             |                                                 | "Percentual de votos brancos: 20.0%" |
| 9     | Exibir o percentual de votos nulos         | 1000           | 200          | 100        | 700          | 20.0%             | 10.0%           | 70.0%             |                                                 | "Percentual de votos nulos: 10.0%"   |
| 10    | Exibir o percentual de votos válidos       | 1000           | 200          | 100        | 700          | 20.0%             | 10.0%           | 70.0%             |                                                 | "Percentual de votos válidos: 70.0%" |

*/
