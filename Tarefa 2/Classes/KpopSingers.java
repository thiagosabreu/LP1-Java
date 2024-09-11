public class KpopSingers {
    private String nome;
    private int idade;
    private String grupo;
    private String corCabelo;
    private double altura;

    KpopSingers(String _nome, int _idade, String _grupo, String _corCabelo, double d) {
        this.nome = _nome;
        this.idade = _idade;
        this.grupo = _grupo;
        this.corCabelo = _corCabelo;
        this.altura = d;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getGrupo() {
        return grupo;
    }

    public void setGrupo(String grupo) {
        this.grupo = grupo;
    }

    public String getCorCabelo() {
        return corCabelo;
    }

    public void setCorCabelo(String corCabelo) {
        this.corCabelo = corCabelo;
    }

    public double getAltura() {
        return altura;
    }
    String compararGrupo(KpopSingers outro) {
        String retorno = "";
        if (this.grupo == outro.grupo) {
            retorno = "O " + this.nome + " é do mesmo grupo que " + outro.nome;
        }
        else {
            retorno = "O " + this.nome + " não é do mesmo grupo que " + outro.nome;
        }
        return retorno;
    }
    public void setAltura(double altura) {
        this.altura = altura;
    }
    void Cantar() {
        System.out.println(this.nome + " está cantando.");
    }
    void Dancar() {
        System.out.println(this.nome + " está dançando.");
    }
}
