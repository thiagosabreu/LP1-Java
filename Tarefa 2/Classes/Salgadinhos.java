public class Salgadinhos
{
    String nome;
    String sabor;
    double peso;
    int qtnde;

    Salgadinhos(String _nome, String _sabor, double _peso, int _qtnde) {
        this.nome = _nome;
        this.sabor = _sabor;
        this.peso = _peso;
        this.qtnde = _qtnde;
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
    double getPeso() {
        return this.peso;
    }
    void setPeso(Float _peso) {
        this.peso = _peso;
    }
    void compararPeso(Salgadinhos outro) {
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
        System.out.println(retorno);
    }
    void Comer()
    {
        this.qtnde -= 1;
        System.out.println("Um " + this.nome + " foi comido, ainda tem " + this.qtnde);
    }
}