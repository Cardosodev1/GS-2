package br.com.fiap.dao;

import br.com.fiap.to.PerguntaTO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class PerguntaDAO extends Repository {
    public ArrayList<PerguntaTO> findAll() {
        ArrayList<PerguntaTO> perguntas = new ArrayList<>();
        String sql = "select * from t_gs_pergunta order by cd_pergunta";
        try (PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            if (rs != null) {
                while (rs.next()) {
                    PerguntaTO pergunta = new PerguntaTO();
                    pergunta.setCodigo(rs.getLong("cd_pergunta"));
                    pergunta.setDescricao(rs.getString("ds_pergunta"));
                    pergunta.setCodigoQuiz(rs.getLong("cd_quiz"));
                    perguntas.add(pergunta);
                }
            } else {
                return null;
            }
        } catch (SQLException e) {
            System.out.println("Erro na consulta: " + e.getMessage());
        } finally {
            closeConnection();
        }
        return perguntas;
    }

    public PerguntaTO findByCodigo(Long codigo) {
        PerguntaTO pergunta = new PerguntaTO();
        String sql = "select * from t_gs_pergunta where cd_pergunta = ?";
        try (PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ps.setLong(1, codigo);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                pergunta.setCodigo(rs.getLong("cd_pergunta"));
                pergunta.setDescricao(rs.getString("ds_pergunta"));
                pergunta.setCodigoQuiz(rs.getLong("cd_quiz"));
            } else {
                return null;
            }

        } catch (SQLException e) {
            System.out.println("Erro na consulta: " + e.getMessage());
        } finally {
            closeConnection();
        }
        return pergunta;
    }

    public PerguntaTO save(PerguntaTO pergunta) {
        String sql = "insert into t_gs_pergunta (ds_pergunta, cd_quiz) values(?, ?)";
        try (PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ps.setString(1, pergunta.getDescricao());
            ps.setLong(2, pergunta.getCodigoQuiz());
            if (ps.executeUpdate() > 0) {
                return pergunta;
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
        String sql = "delete from t_gs_pergunta where cd_pergunta = ?";
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

    public PerguntaTO update(PerguntaTO pergunta) {
        String sql = "update t_gs_pergunta set ds_pergunta=?, cd_quiz=? where cd_pergunta=?";
        try(PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ps.setString(1, pergunta.getDescricao());
            ps.setLong(2, pergunta.getCodigoQuiz());
            ps.setLong(3, pergunta.getCodigo());
            if (ps.executeUpdate() > 0) {
                return pergunta;
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
