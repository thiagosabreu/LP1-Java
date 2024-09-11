public class TrabalhadoresDeEscritorio {
    private String nome;
    private String cargo;
    private double salario;
    private int idade;

    TrabalhadoresDeEscritorio(String _nome, String _cargo, double _salario, int _idade) {
        this.nome = _nome;
        this.cargo = _cargo;
        this.salario = _salario;
        this.idade = _idade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    String compararCargo(TrabalhadoresDeEscritorio outro) {
        String retorno = "";
        if (this.cargo.equals(outro.cargo)) {
            retorno = "O " + this.nome + " tem o mesmo cargo que " + outro.nome;
        } else {
            retorno = "O " + this.nome + " não tem o mesmo cargo que " + outro.nome;
        }
        return retorno;
    }

    void Trabalhar() {
        System.out.println(this.nome + " está trabalhando.");
    }

    void ParticiparDeReuniao() {
        System.out.println(this.nome + " está participando de uma reunião.");
    }
}
