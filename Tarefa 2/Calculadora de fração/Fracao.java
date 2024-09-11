import java.util.Scanner;

public class Fracao {
    private int numerador;
    private int denominador;

    public Fracao(int numerador, int denominador) {
        if (denominador == 0) {
            throw new IllegalArgumentException("Denominador não pode ser zero.");
        }
        this.numerador = numerador;
        this.denominador = denominador;
        simplificar();
    }

    private void simplificar() {
        int mdc = mdc(Math.abs(numerador), Math.abs(denominador));
        numerador /= mdc;
        denominador /= mdc;

        if (denominador < 0) {
            numerador = -numerador;
            denominador = -denominador;
        }
    }

    private int mdc(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    public Fracao somar(Fracao outra) {
        int novoNumerador = this.numerador * outra.denominador + outra.numerador * this.denominador;
        int novoDenominador = this.denominador * outra.denominador;
        return new Fracao(novoNumerador, novoDenominador);
    }

    public Fracao subtrair(Fracao outra) {
        int novoNumerador = this.numerador * outra.denominador - outra.numerador * this.denominador;
        int novoDenominador = this.denominador * outra.denominador;
        return new Fracao(novoNumerador, novoDenominador);
    }

    public Fracao multiplicar(Fracao outra) {
        int novoNumerador = this.numerador * outra.numerador;
        int novoDenominador = this.denominador * outra.denominador;
        return new Fracao(novoNumerador, novoDenominador);
    }

    public Fracao dividir(Fracao outra) {
        if (outra.numerador == 0) {
            throw new IllegalArgumentException("Não é possível dividir por zero.");
        }
        int novoNumerador = this.numerador * outra.denominador;
        int novoDenominador = this.denominador * outra.numerador;
        return new Fracao(novoNumerador, novoDenominador);
    }

    @Override
    public String toString() {
        if (denominador == 1) {
            return String.valueOf(numerador);
        } else {
            return numerador + "/" + denominador;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Quantas frações você deseja inserir? ");
        int quantidade = scanner.nextInt();

        Fracao[] fracoes = new Fracao[quantidade];

        for (int i = 0; i < quantidade; i++) {
            System.out.println("Digite o numerador e denominador da fração " + (i + 1) + ":");
            System.out.print("Numerador " + (i + 1) + ": ");
            int num = scanner.nextInt();
            System.out.print("Denominador " + (i + 1) + ": ");
            int den = scanner.nextInt();
            fracoes[i] = new Fracao(num, den);
        }

        int opcaoMenu;

        do {
            System.out.println("1 - Soma");
            System.out.println("2 - Subtração");
            System.out.println("3 - Multiplicação");
            System.out.println("4 - Divisão");
            System.out.println("5 - Sair");
            System.out.print("Selecione uma opção: ");
            opcaoMenu = scanner.nextInt();

            if (quantidade < 2) {
                System.out.println("Você precisa de pelo menos duas frações para realizar operações.");
                continue;
            }

            Fracao resultado = fracoes[0];
            for (int i = 1; i < quantidade; i++) {
                switch (opcaoMenu) {
                    case 1:
                        resultado = resultado.somar(fracoes[i]);
                        break;
                    case 2:
                        resultado = resultado.subtrair(fracoes[i]);
                        break;
                    case 3:
                        resultado = resultado.multiplicar(fracoes[i]);
                        break;
                    case 4:
                        resultado = resultado.dividir(fracoes[i]);
                        break;
                    case 5:
                        System.out.println("Saindo...");
                        break;
                    default:
                        System.out.println("Opção inválida.");
                        break;
                }
            }

            if (opcaoMenu >= 1 && opcaoMenu <= 4) {
                System.out.println("Resultado: " + resultado);
            }
        } while (opcaoMenu != 5);

        scanner.close();
    }
}
/* Teste de Mesa 2/5+3/7 :

| Passo | Descrição                            | num1 | den1 | num2 | den2 | Operação        | Cálculo                             | Resultado |
|-------|--------------------------------------|------|------|------|------|-----------------|-------------------------------------|-----------|
| 1     | Criação da primeira fração            | 2    | 5    |      |      | Simplificação   | 2/5                                 | 2/5       |
| 2     | Criação da segunda fração             |      |      | 3    | 7    | Simplificação   | 3/7                                 | 3/7       |
| 3     | Soma das frações                      | 2    | 5    | 3    | 7    | Soma            | (2*7 + 3*5) / (5*7)                 | 29/35     |
*/

/* Teste de Mesa 4/3-2/7 :

| Passo | Descrição                            | num1 | den1 | num2 | den2 | Operação        | Cálculo                             | Resultado |
|-------|--------------------------------------|------|------|------|------|-----------------|-------------------------------------|-----------|
| 1     | Criação da primeira fração            | 4    | 3    |      |      | Simplificação   | 4/3                                 | 4/3       |
| 2     | Criação da segunda fração             |      |      | 2    | 7    | Simplificação   | 2/7                                 | 2/7       |
| 3     | Subtração das frações                 | 4    | 3    | 2    | 7    | Subtração       | (4*7 - 2*3) / (3*7)                 | 22/21     |
*/
