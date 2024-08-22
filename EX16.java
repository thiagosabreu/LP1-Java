public class EX16 {
    public static void main(String[] args) {

        double janeiro = 15000;
        double fev = 23000;
        double marco = 17000;

        double gasto_total = janeiro + fev + marco;
        double media = gasto_total / 3;

        System.out.println("O gasto total é de R$: " + gasto_total);
        System.out.println("E a média desse gasto é de R$: " + media);
    }
}

/*
Teste de Mesa:

| Passo | Descrição                            | janeiro | fev  | marco | gasto_total | media    | Cálculo                        | Resultado                          |
|-------|--------------------------------------|---------|------|-------|-------------|----------|--------------------------------|------------------------------------|
| 1     | Entrada: Valor de janeiro            | 15000   |      |       |             |          |                                |                                    |
| 2     | Entrada: Valor de fevereiro          | 15000   | 23000|       |             |          |                                |                                    |
| 3     | Entrada: Valor de março              | 15000   | 23000| 17000 |             |          |                                |                                    |
| 4     | Calcular o gasto total               | 15000   | 23000| 17000 | 55000       |          | `janeiro + fev + marco`         | 55000                              |
| 5     | Calcular a média                     | 15000   | 23000| 17000 | 55000       | 18333.33 | `gasto_total / 3`              | 18333.33                           |
| 6     | Exibir o gasto total                 | 15000   | 23000| 17000 | 55000       | 18333.33 |                                | "O gasto total é de R$: 55000"     |
| 7     | Exibir a média do gasto              | 15000   | 23000| 17000 | 55000       | 18333.33 |                                | "E a média desse gasto é de R$: 18333.33" |
*/
