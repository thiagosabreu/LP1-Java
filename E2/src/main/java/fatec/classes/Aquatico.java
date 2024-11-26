package fatec.classes;

public class Aquatico extends Animal {

    private int id;
    private boolean viveEmAguasSalgadas;

    public Aquatico(int id, String nome, int idade, double peso, boolean viveEmAguasSalgadas) {
        super(nome, idade, peso);
        this.id = id;
        this.viveEmAguasSalgadas = viveEmAguasSalgadas;
    }
    public Aquatico(String nome, int idade, double peso, boolean viveEmAguasSalgadas) {
        super(nome, idade, peso);
        this.viveEmAguasSalgadas = viveEmAguasSalgadas;
    }

    public int getId() {
        return id;
    }

    public boolean isViveEmAguasSalgadas() {
        return viveEmAguasSalgadas;
    }

    public void setViveEmAguasSalgadas(boolean viveEmAguasSalgadas) {
        this.viveEmAguasSalgadas = viveEmAguasSalgadas;
    }

    @Override
    public String FazerSom() {
        return getNome() + " está fazendo som de animal aquático.";
    }

    public String Nadar() {
        return getNome() + " está nadando.";
    }

    public String Mergulhar() {
        return getNome() + " está mergulhando.";
    }
}
