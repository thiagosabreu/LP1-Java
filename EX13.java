import java.util.Scanner;

public class EX13 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Informe um valor: ");
        int valor1 = scanner.nextInt();

        System.out.print("Informe outro valor: ");
        int valor2 = scanner.nextInt();

        if (valor1 < valor2) {
            System.out.print("Em ordem crescente: " + valor1 + ", " + valor2);
        } else if (valor2 < valor1) {
            System.out.print("Em ordem crescente: " + valor2 + ", " + valor1);
        } else {
            System.out.print("Os números são iguais.");
        }
        scanner.close();
    }
}

/*

| Passo | Descrição                                    | valor1 | valor2 | Cálculo                  | Resultado                          |
|-------|----------------------------------------------|--------|--------|--------------------------|------------------------------------|
| 1     | Entrada: Primeiro valor                      | 5      |        |                          |                                    |
| 2     | Entrada: Segundo valor                       | 8      | 5      |                          |                                    |
| 3     | Verificar se valor1 < valor2                 | 5      | 8      | `5 < 8`                  | Verdadeiro (true)                  |
| 4     | Exibir mensagem: "Em ordem crescente: 5, 8"  | 5      | 8      |                          | "Em ordem crescente: 5, 8"         |
| 5     | Verificar se valor2 < valor1                 | 5      | 8      | `8 < 5`                  | Falso (false)                      |
| 6     | Exibir mensagem: "Em ordem crescente: 5, 8"  | 8      | 5      |                          | "Em ordem crescente: 5, 8"         |
| 7     | Verificar se os números são iguais           | 5      | 5      | `5 == 5`                 | Verdadeiro (true)                  |
| 8     | Exibir mensagem: "Os números são iguais."    | 5      | 5      |                          | "Os números são iguais."           |

*/
