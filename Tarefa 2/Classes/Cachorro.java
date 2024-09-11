public class Cachorro {
    private String nome;
    private String raca;
    private double peso;
    private int idade;

    Cachorro(String _nome, String _raca, double d, int _idade) {
        this.nome = _nome;
        this.raca = _raca;
        this.peso = d;
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

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
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
