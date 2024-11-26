package fatec.classes;

public class Caminhao extends Veiculo {

    private int id;
    private double capacidadeCarga;

    public Caminhao(int id, String marca, String modelo, int ano, double peso, double capacidadeCarga) {
        super(marca, modelo, ano, peso);
        this.id = id;
        this.capacidadeCarga = capacidadeCarga;
    }
    public Caminhao(String marca, String modelo, int ano, double peso, double capacidadeCarga) {
        super(marca, modelo, ano, peso);
        this.capacidadeCarga = capacidadeCarga;
    }

    public int getId() {
        return id;
    }

    public double getCapacidadeCarga() {
        return capacidadeCarga;
    }

    public void setCapacidadeCarga(double capacidadeCarga) {
        this.capacidadeCarga = capacidadeCarga;
    }

    @Override
    public String Acelerar() {
        return "O caminhão está acelerando.";
    }

    @Override
    public String Frear() {
        return "O caminhão está freando.";
    }

    public String Carregar() {
        return "O caminhão está sendo carregado.";
    }
}
