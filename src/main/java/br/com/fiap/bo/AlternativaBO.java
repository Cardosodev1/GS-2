package br.com.fiap.bo;

import br.com.fiap.dao.AlternativaDAO;
import br.com.fiap.to.AlternativaTO;

import java.util.ArrayList;

public class AlternativaBO {
    private AlternativaDAO alternativaDAO;

    public ArrayList<AlternativaTO> findAll() {
        alternativaDAO = new AlternativaDAO();
        // aqui se implementa a regra de negócios
        return alternativaDAO.findAll();
    }

    public AlternativaTO findByCodigo(Long codigo) {
        alternativaDAO = new AlternativaDAO();
        // aqui se implementa a regra de negócios
        return alternativaDAO.findByCodigo(codigo);
    }

    public AlternativaTO save(AlternativaTO alternativa) {
        alternativaDAO = new AlternativaDAO();
        // aqui se implementa a regra de negócios
        return alternativaDAO.save(alternativa);
    }

    public boolean delete(Long codigo) {
        alternativaDAO = new AlternativaDAO();
        // aqui se implementa a regra de negócios
        return alternativaDAO.delete(codigo);
    }

    public AlternativaTO update(AlternativaTO alternativa) {
        alternativaDAO = new AlternativaDAO();
        // aqui se implementa a regra de negócios
        return alternativaDAO.update(alternativa);
    }
}
