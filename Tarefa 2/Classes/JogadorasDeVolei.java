public class JogadorasDeVolei {
    private String nome;
    private String posicao;
    private float altura;
    private int numeroCamisa;
    private int idade;

    JogadorasDeVolei(String _nome, String _posicao, float _altura, int _numeroCamisa, int _idade) {
        this.nome = _nome;
        this.posicao = _posicao;
        this.altura = _altura;
        this.numeroCamisa = _numeroCamisa;
        this.idade = _idade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getPosicao() {
        return posicao;
    }

    public void setPosicao(String posicao) {
        this.posicao = posicao;
    }

    public float getAltura() {
        return altura;
    }

    public void setAltura(float altura) {
        this.altura = altura;
    }

    public int getNumeroCamisa() {
        return numeroCamisa;
    }

    public void setNumeroCamisa(int numeroCamisa) {
        this.numeroCamisa = numeroCamisa;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    String compararAltura(JogadorasDeVolei outra) {
        if (this.altura > outra.altura) {
            return this.nome + " é mais alta que " + outra.nome;
        } else if (this.altura < outra.altura) {
            return this.nome + " é mais baixa que " + outra.nome;
        } else {
            return this.nome + " e " + outra.nome + " têm a mesma altura.";
        }
    }

    void Sacar() {
        System.out.println(this.nome + " está sacando.");
    }

    void Bloquear() {
        System.out.println(this.nome + " está bloqueando.");
    }

    void Atacar() {
        System.out.println(this.nome + " está atacando.");
    }

    String compararPosicao(JogadorasDeVolei outra) {
        if (this.posicao.equals(outra.posicao)) {
            return this.nome + " joga na mesma posição que " + outra.nome;
        } else {
            return this.nome + " não joga na mesma posição que " + outra.nome;
        }
    }
}
