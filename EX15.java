import java.util.Scanner;

public class EX15 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite o total de horas trabalhadas no mês: ");
        int horasTrabalhadas = scanner.nextInt();

        System.out.print("Digite o valor pago por hora: ");
        int valorHora = scanner.nextInt();

        int horasNormais = 160;
        double salarioTotal;

        if (horasTrabalhadas > horasNormais) {
            int horasAdicionais = horasTrabalhadas - horasNormais;
            double valorHoraAdicional = valorHora * 1.5;
            salarioTotal = (horasNormais * valorHora) + (horasAdicionais * valorHoraAdicional);
        } else {
            salarioTotal = horasTrabalhadas * valorHora;
        }

        System.out.println("Seu salário este mês é R$: " + salarioTotal);
        scanner.close();
    }
}

/*

| Passo | Descrição                                      | horasTrabalhadas | valorHora | Cálculo                                       | Resultado                    |
|-------|------------------------------------------------|------------------|-----------|-----------------------------------------------|------------------------------|
| 1     | Entrada: Total de horas trabalhadas no mês     | 170              |           |                                               |                              |
| 2     | Entrada: Valor pago por hora                   | 20               | 20        |                                               |                              |
| 3     | Verificar se horasTrabalhadas > horasNormais   | 170              | 20        | `170 > 160`                                  | Verdadeiro (true)            |
| 4     | Calcular horas adicionais                      | 170              | 20        | `170 - 160`                                  | 10                           |
| 5     | Calcular valor da hora adicional               | 170              | 20        | `20 * 1.5`                                   | 30                           |
| 6     | Calcular o salário total com horas adicionais  | 170              | 20        | `(160 * 20) + (10 * 30)`                     | 3700                         |
| 7     | Exibir mensagem                                | 170              | 20        |                                               | "Seu salário este mês é R$: 3700" |

*/
