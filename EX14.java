import java.util.Scanner;

public class EX14 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Hora de início: ");
        int horaInicio = scanner.nextInt();

        System.out.print("Hora de término: ");
        int horaTermino = scanner.nextInt();

        int duracao;
        if (horaTermino >= horaInicio) {
            duracao = horaTermino - horaInicio;
        } else {
            duracao = (24 - horaInicio) + horaTermino;
        }

        System.out.println("A duração do jogo foi de " + duracao + " horas.");
        scanner.close();
    }
}

/*

| Passo | Descrição                                    | horaInicio | horaTermino | Cálculo                           | Resultado                   |
|-------|----------------------------------------------|------------|-------------|-----------------------------------|-----------------------------|
| 1     | Entrada: Hora de início                      | 9          |             |                                   |                             |
| 2     | Entrada: Hora de término                     | 17         | 17          |                                   |                             |
| 3     | Verificar se horaTermino >= horaInicio       | 9          | 17          | `17 >= 9`                         | Verdadeiro (true)           |
| 4     | Calcular duração (horaTermino - horaInicio)  | 9          | 17          | `17 - 9`                          | 8                           |
| 5     | Exibir mensagem: "A duração do jogo foi de 8 horas." | 9    | 17          |                                   | "A duração do jogo foi de 8 horas." |

*/
