import java.util.Scanner;

public class EX1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Informe sua idade em anos: ");
        int idadeAnos = scanner.nextInt();
        
        int totalDias = idadeAnos * 365;
        int totalMeses = idadeAnos * 12;
        int diasMeses = totalMeses * 30;
        
        System.out.println("Sua idade convertida em dias: " + totalDias);

        scanner.close();
    }
}

/* Análise de Execução:

| Passo | Descrição                              | idadeAnos | totalMeses | totalDias | diasMeses | Cálculo                     | Resultado |
|-------|----------------------------------------|-----------|------------|-----------|-----------|-----------------------------|-----------|
| 1     | Entrada: Idade em anos                 | 2         |            |           |           |                             |           |
| 2     | Converter anos para meses              | 2         | 24         |           |           | `idadeAnos * 12`            | 24        |
| 3     | Converter anos para dias               | 2         | 24         | 730       |           | `idadeAnos * 365`           | 730       |
| 4     | Converter meses para dias              | 2         | 24         | 730       | 720       | `totalMeses * 30`           | 720       |
| 5     | Exibir resultado em dias               | 2         | 24         | 730       | 720       | `totalDias`                 | 730       | */
