package modelo_b;

public class Estacao {
    private int idEstacao;
    private String siglaEstacao;
    private String cidade;
    private double potenciaKw;

    public Estacao() {}

    public Estacao(int idEstacao, String siglaEstacao, String cidade, double potenciaKw) {
        this.idEstacao = idEstacao;
        this.siglaEstacao = siglaEstacao;
        this.cidade = cidade;
        this.potenciaKw = potenciaKw;
    }

    @Override
    public String toString() {
        String aux = "";
        aux += "ID: " + idEstacao + "   |  ";
        aux += "Sigla: " + siglaEstacao + "   |   ";
        aux += "Cidade: " + cidade + "   |   ";
        aux += String.format("Potência (Kw): " + String.format("%.2f", potenciaKw));
        return aux;
    }

    public int getIdEstacao() {
        return idEstacao;
    }

    public void setIdEstacao(int idEstacao) {
        this.idEstacao = idEstacao;
    }

    public String getSiglaEstacao() {
        return siglaEstacao;
    }

    public void setSiglaEstacao(String siglaEstacao) {
        this.siglaEstacao = siglaEstacao;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public double getPotenciaKw() {
        return potenciaKw;
    }

    public void setPotenciaKw(double potenciaKw) {
        this.potenciaKw = potenciaKw;
    }
}

