package br.com.fiap.bo;

import br.com.fiap.dao.QuizDAO;
import br.com.fiap.to.QuizTO;

import java.util.ArrayList;

public class QuizBO {
    private QuizDAO quizDAO;

    public ArrayList<QuizTO> findAll() {
        quizDAO = new QuizDAO();
        // aqui se implementa a regra de negócios
        return quizDAO.findAll();
    }

    public QuizTO findByCodigo(Long codigo) {
        quizDAO = new QuizDAO();
        // aqui se implementa a regra de negócios
        return quizDAO.findByCodigo(codigo);
    }

    public QuizTO save(QuizTO quiz) {
        quizDAO = new QuizDAO();
        // aqui se implementa a regra de negócios
        return quizDAO.save(quiz);
    }

    public boolean delete(Long codigo) {
        quizDAO = new QuizDAO();
        // aqui se implementa a regra de negócios
        return quizDAO.delete(codigo);
    }

    public QuizTO update(QuizTO quiz) {
        quizDAO = new QuizDAO();
        // aqui se implementa a regra de negócios
        return quizDAO.update(quiz);
    }
}
