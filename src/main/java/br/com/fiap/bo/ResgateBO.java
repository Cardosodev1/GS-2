package br.com.fiap.bo;

import br.com.fiap.dao.ResgateDAO;
import br.com.fiap.to.ResgateTO;

import java.util.ArrayList;

public class ResgateBO {
    private ResgateDAO resgateDAO;

    public ArrayList<ResgateTO> findAll() {
        resgateDAO = new ResgateDAO();
        // aqui se implementa a regra de negócios
        return resgateDAO.findAll();
    }

    public ResgateTO findByCodigo(Long codigo) {
        resgateDAO = new ResgateDAO();
        // aqui se implementa a regra de negócios
        return resgateDAO.findByCodigo(codigo);
    }

    public ResgateTO save(ResgateTO resgate) {
        resgateDAO = new ResgateDAO();
        // aqui se implementa a regra de negócios
        return resgateDAO.save(resgate);
    }

    public boolean delete(Long codigo) {
        resgateDAO = new ResgateDAO();
        // aqui se implementa a regra de negócios
        return resgateDAO.delete(codigo);
    }

    public ResgateTO update(ResgateTO resgate) {
        resgateDAO = new ResgateDAO();
        // aqui se implementa a regra de negócios
        return resgateDAO.update(resgate);
    }
}
