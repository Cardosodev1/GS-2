package br.com.fiap.dao;

import br.com.fiap.to.ResgateTO;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ResgateDAO extends Repository {
    public ArrayList<ResgateTO> findAll() {
        ArrayList<ResgateTO> resgates = new ArrayList<>();
        String sql = "select * from t_gs_resgate order by cd_resgate";
        try (PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            if (rs != null) {
                while (rs.next()) {
                    ResgateTO resgate = new ResgateTO();
                    resgate.setCodigo(rs.getLong("cd_resgate"));
                    resgate.setDataResgate(rs.getDate("dt_resgate").toLocalDate());
                    resgate.setCodigoUsuario(rs.getLong("cd_usuario"));
                    resgate.setCodigoRecompensa(rs.getLong("cd_recompensa"));
                    resgates.add(resgate);
                }
            } else {
                return null;
            }
        } catch (SQLException e) {
            System.out.println("Erro na consulta: " + e.getMessage());
        } finally {
            closeConnection();
        }
        return resgates;
    }

    public ResgateTO findByCodigo(Long codigo) {
        ResgateTO resgate = new ResgateTO();
        String sql = "select * from t_gs_resgate where cd_resgate = ?";
        try (PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ps.setLong(1, codigo);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                resgate.setCodigo(rs.getLong("cd_resgate"));
                resgate.setDataResgate(rs.getDate("dt_resgate").toLocalDate());
                resgate.setCodigoUsuario(rs.getLong("cd_usuario"));
                resgate.setCodigoRecompensa(rs.getLong("cd_recompensa"));
            } else {
                return null;
            }

        } catch (SQLException e) {
            System.out.println("Erro na consulta: " + e.getMessage());
        } finally {
            closeConnection();
        }
        return resgate;
    }

    public ResgateTO save(ResgateTO resgate) {
        String sql = "insert into t_gs_resgate (dt_resgate, cd_usuario, cd_recompensa) values(?, ?, ?)";
        try (PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ps.setDate(1, Date.valueOf(resgate.getDataResgate()));
            ps.setLong(2, resgate.getCodigoUsuario());
            ps.setLong(3, resgate.getCodigoRecompensa());
            if (ps.executeUpdate() > 0) {
                return resgate;
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
        String sql = "delete from t_gs_resgate where cd_resgate = ?";
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

    public ResgateTO update(ResgateTO resgate) {
        String sql = "update t_gs_resgate set dt_resgate=?, cd_usuario=?, cd_recompensa=? where cd_resgate=?";
        try(PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ps.setDate(1, Date.valueOf(resgate.getDataResgate()));
            ps.setLong(2, resgate.getCodigoUsuario());
            ps.setLong(3, resgate.getCodigoRecompensa());
            ps.setLong(4, resgate.getCodigo());
            if (ps.executeUpdate() > 0) {
                return resgate;
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
