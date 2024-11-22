package br.com.fiap.dao;

import br.com.fiap.to.QuizTO;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class QuizDAO extends Repository {
    public ArrayList<QuizTO> findAll() {
        ArrayList<QuizTO> quizes = new ArrayList<>();
        String sql = "select * from t_gs_quiz order by cd_quiz";
        try (PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            if (rs != null) {
                while (rs.next()) {
                    QuizTO quiz = new QuizTO();
                    quiz.setCodigo(rs.getLong("cd_quiz"));
                    quiz.setDataDisponivel(rs.getDate("dt_resgate").toLocalDate());
                    quiz.setCodigoArtigo(rs.getLong("cd_artigo"));
                    quizes.add(quiz);
                }
            } else {
                return null;
            }
        } catch (SQLException e) {
            System.out.println("Erro na consulta: " + e.getMessage());
        } finally {
            closeConnection();
        }
        return quizes;
    }

    public QuizTO findByCodigo(Long codigo) {
        QuizTO quiz = new QuizTO();
        String sql = "select * from t_gs_quiz where cd_quiz = ?";
        try (PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ps.setLong(1, codigo);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                quiz.setCodigo(rs.getLong("cd_quiz"));
                quiz.setDataDisponivel(rs.getDate("dt_resgate").toLocalDate());
                quiz.setCodigoArtigo(rs.getLong("cd_artigo"));
            } else {
                return null;
            }

        } catch (SQLException e) {
            System.out.println("Erro na consulta: " + e.getMessage());
        } finally {
            closeConnection();
        }
        return quiz;
    }

    public QuizTO save(QuizTO quiz) {
        String sql = "insert into t_gs_quiz (dt_disponivel, cd_artigo) values(?, ?)";
        try (PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ps.setDate(1, Date.valueOf(quiz.getDataDisponivel()));
            ps.setLong(2, quiz.getCodigoArtigo());
            if (ps.executeUpdate() > 0) {
                return quiz;
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
        String sql = "delete from t_gs_quiz where cd_quiz = ?";
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

    public QuizTO update(QuizTO quiz) {
        String sql = "update t_gs_quiz set dt_disponivel=?, cd_artigo=? where cd_quiz=?";
        try(PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ps.setDate(1, Date.valueOf(quiz.getDataDisponivel()));
            ps.setLong(2, quiz.getCodigoArtigo());
            ps.setLong(3, quiz.getCodigo());
            if (ps.executeUpdate() > 0) {
                return quiz;
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
