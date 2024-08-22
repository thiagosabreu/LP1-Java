import java.util.Scanner;

public class EX11 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Informe o ano atual: ");
        int anoAtual = scanner.nextInt();

        System.out.print("Informe seu ano de nascimento: ");
        int anoNascimento = scanner.nextInt();

        if (anoAtual - anoNascimento >= 16) {
            System.out.print("Você está apto a votar este ano.");
        } else {
            System.out.print("Você não está apto a votar este ano.");
        }
        scanner.close();
    }
}

/*

| Passo | Descrição                                    | anoAtual | anoNascimento | Cálculo                  | Resultado                     |
|-------|----------------------------------------------|----------|---------------|--------------------------|-------------------------------|
| 1     | Entrada: Ano atual                           | 2024     |               |                          |                               |
| 2     | Entrada: Ano de nascimento                   | 2024     | 2006          |                          |                               |
| 3     | Calcular a diferença entre anos              | 2024     | 2006          | `2024 - 2006`            | 18                            |
| 4     | Verificar se a diferença é >= 16             | 2024     | 2006          | `18 >= 16`               | Verdadeiro (true)             |
| 5     | Exibir mensagem: "Você está apto a votar este ano." | 2024 | 2006          |                          | "Você está apto a votar este ano." |

*/
