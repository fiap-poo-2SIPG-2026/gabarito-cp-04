package modelo_c;

public class ItemEstoque {
    private int id;
    private String nome;
    private String fornecedor;
    private double quantidade;

    public ItemEstoque() {}

    public ItemEstoque(int id, String nome, String fornecedor, double quantidade) {
        this.id = id;
        this.nome = nome;
        this.fornecedor = fornecedor;
        this.quantidade = quantidade;
    }

    @Override
    public String toString() {
        String aux = "";
        aux += "ID: " + id + "   |  ";
        aux += "Nome: " + nome + "   |   ";
        aux += "Fornecedor: " + fornecedor + "   |   ";
        aux += String.format("Quantidade (Kg): " + String.format("%.2f", quantidade));
        return aux;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(String fornecedor) {
        this.fornecedor = fornecedor;
    }

    public double getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(double quantidade) {
        this.quantidade = quantidade;
    }
}


