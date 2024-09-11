public class Flores {
    private String nome;
    private String cor;
    private String tipo;

    Flores(String _nome, String _cor, String _tipo) {
        this.nome = _nome;
        this.cor = _cor;
        this.tipo = _tipo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    String compararTipo(Flores outra) {
        String retorno = "";
        if (this.tipo.equals(outra.tipo)) {
            retorno = "A " + this.nome + " é do mesmo tipo que a " + outra.nome;
        } else {
            retorno = "A " + this.nome + " não é do mesmo tipo que a " + outra.nome;
        }
        return retorno;
    }

    void Florescer() {
        System.out.println(this.nome + " está florescendo.");
    }

    void Murchar() {
        System.out.println(this.nome + " está murchando.");
    }
}
