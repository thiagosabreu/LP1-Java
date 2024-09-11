public class Refrigerante {
    private String nome;
    private String sabor;
    private String marca;
    private int volumeML;
    private boolean diet;

    Refrigerante(String _nome, String _sabor, String _marca, int _volumeML, boolean _diet) {
        this.nome = _nome;
        this.sabor = _sabor;
        this.marca = _marca;
        this.volumeML = _volumeML;
        this.diet = _diet;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSabor() {
        return sabor;
    }

    public void setSabor(String sabor) {
        this.sabor = sabor;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public int getVolumeML() {
        return volumeML;
    }

    public void setVolumeML(int volumeML) {
        this.volumeML = volumeML;
    }

    public boolean isDiet() {
        return diet;
    }

    public void setDiet(boolean diet) {
        this.diet = diet;
    }

    String compararSabor(Refrigerante outro) {
        if (this.sabor.equals(outro.sabor)) {
            return "O " + this.nome + " tem o mesmo sabor que o " + outro.nome;
        } else {
            return "O " + this.nome + " não tem o mesmo sabor que o " + outro.nome;
        }
    }

    void abrir() {
        System.out.println(this.nome + " foi aberto e está pronto para ser consumido.");
    }

    void servir() {
        System.out.println(this.nome + " está sendo servido.");
    }

    String compararVolume(Refrigerante outro) {
        if (this.volumeML > outro.volumeML) {
            return this.nome + " tem um volume maior que " + outro.nome;
        } else if (this.volumeML < outro.volumeML) {
            return this.nome + " tem um volume menor que " + outro.nome;
        } else {
            return this.nome + " e " + outro.nome + " têm o mesmo volume.";
        }
    }
}
