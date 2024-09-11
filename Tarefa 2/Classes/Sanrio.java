public class Sanrio {
    String nome;
    String comidaFav;
    String cor;
    int idade;

    Sanrio(String _nome, String _comidaFav, String _cor, int _idade) {
        this.nome = _nome;
        this.comidaFav = _comidaFav;
        this.cor = _cor;
        this.idade = _idade;
    }
    
    String getNome() {
        return this.nome;
    }
    void setNome (String _nome) {
        this.nome = _nome;
    }
    String getComidaFav() {
        return this.comidaFav;
    }
    void setComidaFav (String _comidaFav) {
        this.comidaFav = _comidaFav;
    }
    String getCor() {
        return this.cor;
    }
    void setCor (String _cor) {
        this.cor = _cor;
    }
    int getIdade() {
        return this.idade;
    }
    void setCor (int _idade) {
        this.idade = _idade;
    }
    void Brincar()
    {
        System.out.println(this.nome + " está feliz porque brincou");
    }
    void Cozinhar()
    {
        System.out.println(this.nome + " está cozinhando" + this.comidaFav);
    }
}
