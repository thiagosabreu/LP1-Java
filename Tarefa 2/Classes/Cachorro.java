public class Cachorro {
    private String nome;
    private String raca;
    private float peso;
    private int idade;

    Cachorro(String _nome, String _raca, float _peso, int _idade) {
        this.nome = _nome;
        this.raca = _raca;
        this.peso = _peso;
        this.idade = _idade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getRaca() {
        return raca;
    }

    public float getPeso() {
        return peso;
    }

    public void setPeso(float peso) {
        this.peso = peso;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    String compararRaca(Cachorro outro) {
        String retorno = "";
        if (this.raca.equals(outro.raca)) {
            retorno = "O " + this.nome + " é da mesma raça que " + outro.nome;
        } else {
            retorno = "O " + this.nome + " não é da mesma raça que " + outro.nome;
        }
        return retorno;
    }

    void Latir() {
        System.out.println(this.nome + " está latindo.");
    }

    void Correr() {
        System.out.println(this.nome + " está correndo.");
    }
}
