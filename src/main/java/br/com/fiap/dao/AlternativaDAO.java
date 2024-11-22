package br.com.fiap.dao;

import br.com.fiap.to.AlternativaTO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class AlternativaDAO extends Repository {
    public ArrayList<AlternativaTO> findAll() {
        ArrayList<AlternativaTO> alternativas = new ArrayList<>();
        String sql = "select * from t_gs_alternativa order by cd_alternativa";
        try (PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            if (rs != null) {
                while (rs.next()) {
                    AlternativaTO alternativa = new AlternativaTO();
                    alternativa.setCodigo(rs.getLong("cd_alternativa"));
                    alternativa.setDescricao(rs.getString("ds_alternativa"));
                    alternativa.setCorreta(rs.getString("correta"));
                    alternativa.setCodigoPergunta(rs.getLong("cd_pergunta"));
                    alternativas.add(alternativa);
                }
            } else {
                return null;
            }
        } catch (SQLException e) {
            System.out.println("Erro na consulta: " + e.getMessage());
        } finally {
            closeConnection();
        }
        return alternativas;
    }

    public AlternativaTO findByCodigo(Long codigo) {
        AlternativaTO alternativa = new AlternativaTO();
        String sql = "select * from t_gs_alternativa where cd_alternativa = ?";
        try (PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ps.setLong(1, codigo);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                alternativa.setCodigo(rs.getLong("cd_alternativa"));
                alternativa.setDescricao(rs.getString("ds_alternativa"));
                alternativa.setCorreta(rs.getString("correta"));
                alternativa.setCodigoPergunta(rs.getLong("cd_pergunta"));
            } else {
                return null;
            }

        } catch (SQLException e) {
            System.out.println("Erro na consulta: " + e.getMessage());
        } finally {
            closeConnection();
        }
        return alternativa;
    }

    public AlternativaTO save(AlternativaTO alternativa) {
        String sql = "insert into t_gs_alternativa (ds_alternativa, correta, cd_pergunta) values(?, ?, ?)";
        try (PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ps.setString(1, alternativa.getDescricao());
            ps.setString(2, alternativa.getCorreta());
            ps.setLong(3, alternativa.getCodigoPergunta());
            if (ps.executeUpdate() > 0) {
                return alternativa;
            } else {
                return null;
            }
        } catch (SQLException e) {
            System.out.println("Erro ao salvar: " + e.getMessage());
        } finally {
            closeConnection();
        }
        return null;
    }

    public boolean delete(Long codigo) {
        String sql = "delete from t_gs_alternativa where cd_alternativa = ?";
        try (PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ps.setLong(1, codigo);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Erro ao excluir: " + e.getMessage());
        } finally {
            closeConnection();
        }
        return false;
    }

    public AlternativaTO update(AlternativaTO alternativa) {
        String sql = "update t_gs_alternativa set ds_alternativa=?, correta=?, cd_pergunta=? where cd_alternativa=?";
        try(PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ps.setString(1, alternativa.getDescricao());
            ps.setString(2, alternativa.getCorreta());
            ps.setLong(3, alternativa.getCodigoPergunta());
            ps.setLong(4, alternativa.getCodigo());
            if (ps.executeUpdate() > 0) {
                return alternativa;
            } else {
                return null;
            }
        } catch (SQLException e) {
            System.out.println("Erro ao atualizar: " + e.getMessage());
        } finally {
            closeConnection();
        }
        return null;
    }
}
