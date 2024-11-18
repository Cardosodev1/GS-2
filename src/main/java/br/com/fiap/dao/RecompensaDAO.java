package br.com.fiap.dao;

import br.com.fiap.to.RecompensaTO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class RecompensaDAO extends Repository {
    public ArrayList<RecompensaTO> findAll() {
        ArrayList<RecompensaTO> recompensas = new ArrayList<>();
        String sql = "select * from t_gs_recompensa order by cd_recompensa";
        try (PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            if (rs != null) {
                while (rs.next()) {
                    RecompensaTO recompensa = new RecompensaTO();
                    recompensa.setCodigo(rs.getLong("cd_recompensa"));
                    recompensa.setNomeEmpresa(rs.getString("nm_empresa"));
                    recompensa.setDescricao(rs.getString("ds_recompensa"));
                    recompensa.setImagem(rs.getBlob("img_recompensa"));
                    recompensa.setPontosNecessarios(rs.getLong("pontos_necessarios"));
                    recompensas.add(recompensa);
                }
            } else {
                return null;
            }
        } catch (SQLException e) {
            System.out.println("Erro na consulta: " + e.getMessage());
        } finally {
            closeConnection();
        }
        return recompensas;
    }

    public RecompensaTO findByCodigo(Long codigo) {
        RecompensaTO recompensa = new RecompensaTO();
        String sql = "select * from t_gs_recompensa where cd_recompensa = ?";
        try (PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ps.setLong(1, codigo);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                recompensa.setCodigo(rs.getLong("cd_recompensa"));
                recompensa.setNomeEmpresa(rs.getString("nm_empresa"));
                recompensa.setDescricao(rs.getString("ds_recompensa"));
                recompensa.setImagem(rs.getBlob("img_recompensa"));
                recompensa.setPontosNecessarios(rs.getLong("pontos_necessarios"));
            } else {
                return null;
            }

        } catch (SQLException e) {
            System.out.println("Erro na consulta: " + e.getMessage());
        } finally {
            closeConnection();
        }
        return recompensa;
    }

    public RecompensaTO save(RecompensaTO recompensa) {
        String sql = "insert into t_gs_recompensa (nm_empresa, ds_recompensa, img_recompensa, pontos_necessarios) values(?, ?, ?, ?)";
        try (PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ps.setString(1, recompensa.getNomeEmpresa());
            ps.setString(2, recompensa.getDescricao());
            ps.setBlob(3, recompensa.getImagem());
            ps.setLong(4, recompensa.getPontosNecessarios());
            if (ps.executeUpdate() > 0) {
                return recompensa;
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
        String sql = "delete from t_gs_recompensa where cd_recompensa = ?";
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

    public RecompensaTO update(RecompensaTO recompensa) {
        String sql = "update t_gs_recompensa set nm_empresa=?, ds_recompensa=?, img_recompensa=?, pontos_necessarios=? where cd_recompensa=?";
        try(PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ps.setString(1, recompensa.getNomeEmpresa());
            ps.setString(2, recompensa.getDescricao());
            ps.setBlob(3, recompensa.getImagem());
            ps.setLong(4, recompensa.getPontosNecessarios());
            ps.setLong(5, recompensa.getCodigo());
            if (ps.executeUpdate() > 0) {
                return recompensa;
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
