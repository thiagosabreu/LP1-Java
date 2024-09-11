public class TiposDeCabelo {
    private String tipo;
    private String cor;
    private double comprimento;
    private boolean isNatural;

    TiposDeCabelo(String _tipo, String _cor, double _comprimento, boolean _éNatural) {
        this.tipo = _tipo;
        this.cor = _cor;
        this.comprimento = _comprimento;
        this.isNatural = _éNatural;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String _tipo) {
        this.tipo = _tipo;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String _cor) {
        this.cor = _cor;
    }

    public double getComprimento() {
        return comprimento;
    }

    public void setComprimento(double _comprimento) {
        this.comprimento = _comprimento;
    }

    public boolean isNatural() {
        return isNatural;
    }

    public void setNatural(boolean _isNatural) {
        this.isNatural = _isNatural;
    }

    String compararComprimento(TiposDeCabelo outro) {
        if (this.comprimento > outro.comprimento) {
            return "O cabelo " + this.tipo + " com cor " + this.cor + " é mais comprido que o cabelo " + outro.tipo + " com cor " + outro.cor;
        } else if (this.comprimento < outro.comprimento) {
            return "O cabelo " + this.tipo + " com cor " + this.cor + " é mais curto que o cabelo " + outro.tipo + " com cor " + outro.cor;
        } else {
            return "Os cabelos têm o mesmo comprimento.";
        }
    }

    String compararTipo(TiposDeCabelo outro) {
        if (this.tipo.equals(outro.tipo)) {
            return "O cabelo " + this.tipo + " com cor " + this.cor + " é do mesmo tipo que o cabelo " + outro.tipo + " com cor " + outro.cor;
        } else {
            return "Os cabelos são de tipos diferentes.";
        }
    }

    void cortar(double centimetros) {
        if (this.comprimento >= centimetros) {
            this.comprimento -= centimetros;
            System.out.println("O cabelo foi cortado. O novo comprimento é " + this.comprimento + " cm.");
        } else {
            System.out.println("Não é possível cortar mais do que o comprimento atual do cabelo.");
        }
    }

    void tingir(String novaCor) {
        this.cor = novaCor;
        this.isNatural = false;
        System.out.println("O cabelo foi tingido de " + novaCor + ".");
    }
}
