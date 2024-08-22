import java.util.Scanner;

public class EX17 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Entrada das notas
        System.out.print("Digite a nota da sua P1: ");
        double P1 = scanner.nextDouble();

        System.out.print("Digite a nota do seu E1: ");
        double E1 = scanner.nextDouble();

        System.out.print("Digite a nota do seu E2: ");
        double E2 = scanner.nextDouble();

        System.out.print("Digite a nota da sua API: ");
        double API = scanner.nextDouble();

        System.out.print("Digite a nota das suas notas extras: ");
        double X = scanner.nextDouble();

        System.out.print("Digite a nota da sua SUB (Se tiver): ");
        double SUB = scanner.nextDouble();

        double mediaIntermediaria = P1 * 0.6 + ((E1 + E2) / 2) * 0.4;
        double media = (mediaIntermediaria * 0.5)
                + (Math.max((mediaIntermediaria - 5.9), 0) / (mediaIntermediaria - 5.9))
                * (API * 0.5)
                + X
                + (SUB * 0.2);
        
        media = Math.min(media, 10);

        System.out.printf("A sua média final é: %.2f%n", media);

        scanner.close();
    }
}

/*
Teste de Mesa:

| Passo | Descrição                            | P1   | E1   | E2   | API  | X    | SUB  | mediaIntermediaria | media | Cálculo                                                                                      | Resultado             |
|-------|--------------------------------------|------|------|------|------|------|------|--------------------|-------|----------------------------------------------------------------------------------------------|-----------------------|
| 1     | Entrada: Nota da P1                  | 7.0  |      |      |      |      |      |                    |       |                                                                                              |                       |
| 2     | Entrada: Nota do E1                  | 7.0  | 6.5  |      |      |      |      |                    |       |                                                                                              |                       |
| 3     | Entrada: Nota do E2                  | 7.0  | 6.5  | 8.0  |      |      |      |                    |       |                                                                                              |                       |
| 4     | Entrada: Nota da API                 | 7.0  | 6.5  | 8.0  | 9.0  |      |      |                    |       |                                                                                              |                       |
| 5     | Entrada: Nota das notas extras       | 7.0  | 6.5  | 8.0  | 9.0  | 1.5  |      |                    |       |                                                                                              |                       |
| 6     | Entrada: Nota da SUB                 | 7.0  | 6.5  | 8.0  | 9.0  | 1.5  | 6.0  |                    |       |                                                                                              |                       |
| 7     | Calcular a média intermediária       | 7.0  | 6.5  | 8.0  | 9.0  | 1.5  | 6.0  | 7.20               |       | `P1 * 0.6 + ((E1 + E2) / 2) * 0.4`                                                          | 7.20                  |
| 8     | Calcular a parte 1 da média final    | 7.0  | 6.5  | 8.0  | 9.0  | 1.5  | 6.0  | 7.20               | 3.60  | `mediaIntermediaria * 0.5`                                                                  | 3.60                  |
| 9     | Calcular a parte 2 da média final    | 7.0  | 6.5  | 8.0  | 9.0  | 1.5  | 6.0  | 7.20               | 4.50  | `(Math.max((mediaIntermediaria - 5.9), 0) / (mediaIntermediaria - 5.9)) * (API * 0.5)`    | 4.50                  |
| 10    | Adicionar notas extras à média final | 7.0  | 6.5  | 8.0  | 9.0  | 1.5  | 6.0  | 7.20               | 6.00  | `X`                                                                                         | 1.50                  |
| 11    | Adicionar a nota da SUB à média      | 7.0  | 6.5  | 8.0  | 9.0  | 1.5  | 6.0  | 7.20               | 7.20  | `SUB * 0.2`                                                                                 | 1.20                  |
| 12    | Somar todas as partes da média       | 7.0  | 6.5  | 8.0  | 9.0  | 1.5  | 6.0  | 7.20               | 10.80 | `3.60 + 4.50 + 1.50 + 1.20`                                                                 | 10.80                 |
| 13    | Limitar a média a no máximo 10       | 7.0  | 6.5  | 8.0  | 9.0  | 1.5  | 6.0  | 7.20               | 10.00 | `media = Math.min(media, 10)`                                                               | 10.00                 |
| 14    | Exibir a média final                 | 7.0  | 6.5  | 8.0  | 9.0  | 1.5  | 6.0  | 7.20               | 10.00 |                                                                                              | "A sua média final é: 10.00" |
*/
