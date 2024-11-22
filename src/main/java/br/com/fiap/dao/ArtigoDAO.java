package br.com.fiap.dao;

import br.com.fiap.to.ArtigoTO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ArtigoDAO extends Repository {
    public ArrayList<ArtigoTO> findAll() {
        ArrayList<ArtigoTO> artigos = new ArrayList<>();
        String sql = "select * from t_gs_artigo order by cd_artigo";
        try (PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            if (rs != null) {
                while (rs.next()) {
                    ArtigoTO artigo = new ArtigoTO();
                    artigo.setCodigo(rs.getLong("cd_artigo"));
                    artigo.setTitulo(rs.getString("titulo"));
                    artigo.setDescricao(rs.getString("ds_artigo"));
                    artigo.setConteudo(rs.getString("conteudo"));
                    artigos.add(artigo);
                }
            } else {
                return null;
            }
        } catch (SQLException e) {
            System.out.println("Erro na consulta: " + e.getMessage());
        } finally {
            closeConnection();
        }
        return artigos;
    }

    public ArtigoTO findByCodigo(Long codigo) {
        ArtigoTO artigo = new ArtigoTO();
        String sql = "select * from t_gs_artigo where cd_artigo = ?";
        try (PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ps.setLong(1, codigo);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                artigo.setCodigo(rs.getLong("cd_artigo"));
                artigo.setTitulo(rs.getString("titulo"));
                artigo.setDescricao(rs.getString("ds_artigo"));
                artigo.setConteudo(rs.getString("conteudo"));
            } else {
                return null;
            }

        } catch (SQLException e) {
            System.out.println("Erro na consulta: " + e.getMessage());
        } finally {
            closeConnection();
        }
        return artigo;
    }

    public ArtigoTO save(ArtigoTO artigo) {
        String sql = "insert into t_gs_artigo (titulo, ds_artigo, conteudo) values(?, ?, ?)";
        try (PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ps.setString(1, artigo.getTitulo());
            ps.setString(2, artigo.getDescricao());
            ps.setString(3, artigo.getConteudo());
            if (ps.executeUpdate() > 0) {
                return artigo;
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
        String sql = "delete from t_gs_artigo where cd_artigo = ?";
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

    public ArtigoTO update(ArtigoTO artigo) {
        String sql = "update t_gs_artigo set titulo=?, ds_artigo=?, conteudo=? where cd_artigo=?";
        try(PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ps.setString(1, artigo.getTitulo());
            ps.setString(2, artigo.getDescricao());
            ps.setString(3, artigo.getConteudo());
            ps.setLong(4, artigo.getCodigo());
            if (ps.executeUpdate() > 0) {
                return artigo;
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
