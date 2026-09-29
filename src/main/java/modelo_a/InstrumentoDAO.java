package modelo_a;

import factory.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class InstrumentoDAO {
    public boolean inserir(Instrumento instrumento) {
        String sql = "insert into java_instrumento(id_instrumento, nome_instrumento, tipo, estado_conservacao) " +
                "values(?, ?, ?, ?)";
        try(Connection connection = ConnectionFactory.obterConexao();
            PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, instrumento.getIdInstrumento());
            ps.setString(2, instrumento.getNomeInstrumento());
            ps.setString(3, instrumento.getTipo());
            ps.setString(4, instrumento.getEstadoConservacao());
            ps.execute();
            return true;
        }
        catch(SQLException e) {
            System.out.println("Erro ao inserir no banco de dados");
        }
        return false;
    }

    public boolean pesquisar(int id) {
        String sql = "select * from java_instrumento where id_instrumento = ?";
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
            System.out.println("Erro ao inserir no banco de dados");
        }
        return false;
    }

    public List<Instrumento> listar() {
        List<Instrumento> lista = new ArrayList<>();
        String sql = "select * from java_instrumento";
        try(Connection connection = ConnectionFactory.obterConexao();
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery()) {
            while(rs.next()) {
                Instrumento instrumento = new Instrumento();
                instrumento.setIdInstrumento(rs.getInt("id_instrumento"));
                instrumento.setNomeInstrumento(rs.getString("nome_instrumento"));
                instrumento.setTipo(rs.getString("tipo"));
                instrumento.setEstadoConservacao(rs.getString("estado_conservacao"));
                lista.add(instrumento);
            }
        }
        catch(SQLException e) {
            System.out.println("Erro ao listar dados do banco de dados\n" + e);
        }
        return lista;
    }
}

