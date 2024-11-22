package br.com.fiap.bo;

import br.com.fiap.dao.ArtigoDAO;
import br.com.fiap.to.ArtigoTO;

import java.util.ArrayList;

public class ArtigoBO {
    private ArtigoDAO artigoDAO;

    public ArrayList<ArtigoTO> findAll() {
        artigoDAO = new ArtigoDAO();
        // aqui se implementa a regra de negócios
        return artigoDAO.findAll();
    }

    public ArtigoTO findByCodigo(Long codigo) {
        artigoDAO = new ArtigoDAO();
        // aqui se implementa a regra de negócios
        return artigoDAO.findByCodigo(codigo);
    }

    public ArtigoTO save(ArtigoTO artigo) {
        artigoDAO = new ArtigoDAO();
        // aqui se implementa a regra de negócios
        return artigoDAO.save(artigo);
    }

    public boolean delete(Long codigo) {
        artigoDAO = new ArtigoDAO();
        // aqui se implementa a regra de negócios
        return artigoDAO.delete(codigo);
    }

    public ArtigoTO update(ArtigoTO artigo) {
        artigoDAO = new ArtigoDAO();
        // aqui se implementa a regra de negócios
        return artigoDAO.update(artigo);
    }
}
