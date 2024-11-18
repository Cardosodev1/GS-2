package br.com.fiap.bo;

import br.com.fiap.dao.RecompensaDAO;
import br.com.fiap.to.RecompensaTO;

import java.util.ArrayList;

public class RecompensaBO {
    private RecompensaDAO recompensaDAO;

    public ArrayList<RecompensaTO> findAll() {
        recompensaDAO = new RecompensaDAO();
        // aqui se implementa a regra de negócios
        return recompensaDAO.findAll();
    }

    public RecompensaTO findByCodigo(Long codigo) {
        recompensaDAO = new RecompensaDAO();
        // aqui se implementa a regra de negócios
        return recompensaDAO.findByCodigo(codigo);
    }

    public RecompensaTO save(RecompensaTO recompensa) {
        recompensaDAO = new RecompensaDAO();
        // aqui se implementa a regra de negócios
        return recompensaDAO.save(recompensa);
    }

    public boolean delete(Long codigo) {
        recompensaDAO = new RecompensaDAO();
        // aqui se implementa a regra de negócios
        return recompensaDAO.delete(codigo);
    }

    public RecompensaTO update(RecompensaTO recompensa) {
        recompensaDAO = new RecompensaDAO();
        // aqui se implementa a regra de negócios
        return recompensaDAO.update(recompensa);
    }
}
