public class Salgadinhos
{
    String nome;
    String sabor;
    Float peso;
    int qtnde;

    Salgadinhos(String _nome, String _sabor, Float _peso) {
        this.nome = _nome;
        this.sabor = _sabor;
        this.peso = _peso;
    }

    String getNome() {
        return this.nome;
    }
    void setNome(String _nome) {
        this.nome = _nome;
    }
    String getSabor() {
        return this.sabor;
    }
    void setSabor(String _sabor) {
        this.sabor = _sabor;
    }
    Float getPeso() {
        return peso;
    }
    void setPeso(Float _peso) {
        this.peso = _peso;
    }
    String compararPeso(Salgadinhos outro) {
        String retorno = "";
        if (this.peso > outro.peso) {
            retorno = "O " + this.nome + " tem um peso maior que o " + outro.nome;
        }
        else if (this.peso < outro.peso) {
            retorno = "O " + this.nome + " tem um peso menor que o " + outro.nome;
        }
        else if (this.peso == outro.peso) {
            retorno = "O " + this.nome + " tem o mesmo peso que o " + outro.nome;
        }
        return retorno;
    }
    void Comer()
    {
        this.qtnde -= 1;
    }
}