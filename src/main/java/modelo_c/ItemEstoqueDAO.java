package modelo_c;

import factory.ConnectionFactory;
import modelo_b.Estacao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ItemEstoqueDAO {
    public boolean inserir(ItemEstoque item) {
        String sql = "insert into java_item_estoque(id_item, nome_produto, fornecedor, quantidade) " +
                "values(?, ?, ?, ?)";
        try(Connection connection = ConnectionFactory.obterConexao();
            PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, item.getId());
            ps.setString(2, item.getNome());
            ps.setString(3, item.getFornecedor());
            ps.setDouble(4, item.getQuantidade());
            ps.execute();
            return true;
        }
        catch(SQLException e) {
            System.out.println("Erro ao inserir no banco de dados");
        }
        return false;
    }

    public boolean pesquisar(int id) {
        String sql = "select * from java_item_estoque where id_item = ?";
        try(Connection connection = ConnectionFactory.obterConexao();
            PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, id);
            try(ResultSet rs = ps.executeQuery()) {
                if(rs.next()) {
                    return true;
                }
            }
        }
        catch(SQLException e) {
            System.out.println("Erro ao pesquisar ID");
        }
        return false;
    }

    public List<ItemEstoque> listar() {
        List<ItemEstoque> lista = new ArrayList<>();
        String sql = "select * from java_item_estoque";
        try(Connection connection = ConnectionFactory.obterConexao();
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery()) {
            while(rs.next()) {
                ItemEstoque item = new ItemEstoque();
                item.setId(rs.getInt("id_item"));
                item.setNome(rs.getString("nome_produto"));
                item.setFornecedor(rs.getString("fornecedor"));
                item.setQuantidade(rs.getDouble("quantidade"));
                lista.add(item);
            }
        }
        catch(SQLException e) {
            System.out.println("Erro ao listar dados do banco de dados\n" + e);
        }
        return lista;
    }
}
