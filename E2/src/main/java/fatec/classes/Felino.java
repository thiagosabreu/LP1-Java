package fatec.classes;

public class Felino extends Animal {
    private int id;
    private boolean gostaDeDormir;

    public Felino(int id, String nome, int idade, double peso, boolean gostaDeDormir) {
        super(nome, idade, peso);
        this.id = id;
        this.gostaDeDormir = gostaDeDormir;
    }
    public Felino(String nome, int idade, double peso, boolean gostaDeDormir) {
        super(nome, idade, peso);
        this.gostaDeDormir = gostaDeDormir;
    }

    public int getId() {
        return id;
    }

    public boolean isGostaDeDormir() {
        return gostaDeDormir;
    }

    public void setGostaDeDormir(boolean gostaDeDormir) {
        this.gostaDeDormir = gostaDeDormir;
    }

    @Override
    public String FazerSom() {
        return getNome() + " está miando.";
    }

    public String EscalarArvore() {
        return getNome() + " está escalando uma árvore.";
    }

    public String CacaPresas() {
        return getNome() + " está caçando presas.";
    }
}
