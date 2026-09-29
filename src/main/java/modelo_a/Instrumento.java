package modelo_a;

public class Instrumento {
    private int idInstrumento;
    private String nomeInstrumento;
    private String tipo;
    private String estadoConservacao;

    public Instrumento(int idInstrumento, String nomeInstrumento, String tipo, String estadoConservacao) {
        this.idInstrumento = idInstrumento;
        this.nomeInstrumento = nomeInstrumento;
        this.tipo = tipo;
        this.estadoConservacao = estadoConservacao;
    }

    public Instrumento() { }

    @Override
    public String toString() {
        String aux = "";
        aux += "ID: " + idInstrumento + "   |  ";
        aux += "Instrumento: " + nomeInstrumento + "   |   ";
        aux += "Tipo: " + tipo + "   |   ";
        aux += "Estado: " + estadoConservacao.toUpperCase();
        return aux;
    }

    public String getNomeInstrumento() {
        return nomeInstrumento;
    }

    public void setNomeInstrumento(String nomeInstrumento) {
        this.nomeInstrumento = nomeInstrumento;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getEstadoConservacao() {
        return estadoConservacao;
    }

    public void setEstadoConservacao(String estadoConservacao) {
        this.estadoConservacao = estadoConservacao;
    }

    public int getIdInstrumento() {
        return idInstrumento;
    }

    public void setIdInstrumento(int idInstrumento) {
        this.idInstrumento = idInstrumento;
    }
}

