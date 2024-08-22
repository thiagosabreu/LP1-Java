import java.util.Scanner;

public class EX12 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Informe um número: ");
        int numero1 = scanner.nextInt();

        System.out.print("Informe outro número: ");
        int numero2 = scanner.nextInt();

        if (numero1 > numero2) {
            System.out.print("O maior valor é: " + numero1);
        } else if (numero2 > numero1) {
            System.out.print("O maior valor é: " + numero2);
        } else {
            System.out.print("Os números são iguais.");
        }
        scanner.close();
    }
}

/*

| Passo | Descrição                                    | numero1 | numero2 | Cálculo                  | Resultado                          |
|-------|----------------------------------------------|---------|---------|--------------------------|------------------------------------|
| 1     | Entrada: Primeiro número                     | 7       |         |                          |                                    |
| 2     | Entrada: Segundo número                      | 7       | 5       |                          |                                    |
| 3     | Verificar se numero1 > numero2              | 7       | 5       | `7 > 5`                  | Verdadeiro (true)                  |
| 4     | Exibir mensagem: "O maior valor é: 7"        | 7       | 5       |                          | "O maior valor é: 7"               |
| 5     | Verificar se numero2 > numero1              | 7       | 5       |                          |                                    |
| 6     | Exibir mensagem: "O maior valor é: 5"        | 7       | 5       |                          |                                    |
| 7     | Verificar se os números são iguais          | 7       | 7       |                          | "Os números são iguais."           |

*/
