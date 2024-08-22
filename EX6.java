import java.util.Scanner;

public class EX6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Informe a temperatura em Fahrenheit (°F): ");
        int tempFahrenheit = scanner.nextInt();

        int tempCelsius = (tempFahrenheit - 32) * 5 / 9;
        System.out.println("A temperatura convertida é " + tempCelsius + " °C");

        scanner.close();
    }
}
/* Análise de Execução:

| Passo | Descrição                                      | tempFahrenheit | tempCelsius |                        Cálculo                                  | Resultado                     |
|-------|------------------------------------------------|----------------|-------------|-----------------------------------------------------------------|-------------------------------|
| 1     | Entrada: Informe a temperatura em Fahrenheit   | 98             |             |                                                                 |                               |
| 2     | Calcular a temperatura em Celsius              | 98             |             | `(tempFahrenheit - 32) * 5 / 9`                                 | (98 - 32) * 5 / 9 = 36        |
| 3     | Exibir a temperatura em Celsius                | 98             | 36          |                                                                 | "A temperatura convertida é 36 °C" |

*/
