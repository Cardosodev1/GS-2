package br.com.fiap.bo;

import br.com.fiap.dao.PerguntaDAO;
import br.com.fiap.to.PerguntaTO;

import java.util.ArrayList;

public class PerguntaBO {
    private PerguntaDAO perguntaDAO;

    public ArrayList<PerguntaTO> findAll() {
        perguntaDAO = new PerguntaDAO();
        // aqui se implementa a regra de negócios
        return perguntaDAO.findAll();
    }

    public PerguntaTO findByCodigo(Long codigo) {
        perguntaDAO = new PerguntaDAO();
        // aqui se implementa a regra de negócios
        return perguntaDAO.findByCodigo(codigo);
    }

    public PerguntaTO save(PerguntaTO pergunta) {
        perguntaDAO = new PerguntaDAO();
        // aqui se implementa a regra de negócios
        return perguntaDAO.save(pergunta);
    }

    public boolean delete(Long codigo) {
        perguntaDAO = new PerguntaDAO();
        // aqui se implementa a regra de negócios
        return perguntaDAO.delete(codigo);
    }

    public PerguntaTO update(PerguntaTO pergunta) {
        perguntaDAO = new PerguntaDAO();
        // aqui se implementa a regra de negócios
        return perguntaDAO.update(pergunta);
    }
}
