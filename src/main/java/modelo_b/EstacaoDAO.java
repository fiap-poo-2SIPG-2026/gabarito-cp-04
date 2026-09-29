package modelo_b;

import factory.ConnectionFactory;
import modelo_a.Instrumento;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EstacaoDAO {
    public boolean inserir(Estacao estacao) {
        String sql = "insert into java_estacao_recarga(id_estacao, sigla_estacao, cidade, potencia_kw) " +
                "values(?, ?, ?, ?)";
        try(Connection connection = ConnectionFactory.obterConexao();
            PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, estacao.getIdEstacao());
            ps.setString(2, estacao.getSiglaEstacao());
            ps.setString(3, estacao.getCidade());
            ps.setDouble(4, estacao.getPotenciaKw());
            ps.execute();
            return true;
        }
        catch(SQLException e) {
            System.out.println("Erro ao inserir no banco de dados");
        }
        return false;
    }

    public boolean pesquisar(int id) {
        String sql = "select * from java_estacao_recarga where id_estacao = ?";
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

    public List<Estacao> listar() {
        List<Estacao> lista = new ArrayList<>();
        String sql = "select * from java_estacao_recarga";
        try(Connection connection = ConnectionFactory.obterConexao();
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery()) {
            while(rs.next()) {
                Estacao estacao = new Estacao();
                estacao.setIdEstacao(rs.getInt("id_estacao"));
                estacao.setSiglaEstacao(rs.getString("sigla_estacao"));
                estacao.setCidade(rs.getString("cidade"));
                estacao.setPotenciaKw(rs.getDouble("potencia_kw"));
                lista.add(estacao);
            }
        }
        catch(SQLException e) {
            System.out.println("Erro ao listar dados do banco de dados\n" + e);
        }
        return lista;
    }
}
