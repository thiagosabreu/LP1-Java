package fatec.classes;

public class Carro extends Veiculo {

    private int id;
    private int quantidadePortas;

    public Carro(int id, String marca, String modelo, int ano, double peso, int quantidadePortas) {
        super(marca, modelo, ano, peso);
        this.id = id;
        this.quantidadePortas = quantidadePortas;
    }
    public Carro(String marca, String modelo, int ano, double peso, int quantidadePortas) {
        super(marca, modelo, ano, peso);
        this.quantidadePortas = quantidadePortas;
    }

    public int getId() {
        return id;
    }

    public int getQuantidadePortas() {
        return quantidadePortas;
    }

    public void setQuantidadePortas(int quantidadePortas) {
        this.quantidadePortas = quantidadePortas;
    }

    @Override
    public String Acelerar() {
        return "O carro está acelerando.";
    }

    @Override
    public String Frear() {
        return "O carro está freando.";
    }

    public String AbrirPorta() {
        return "A porta do carro está sendo aberta.";
    }
}
