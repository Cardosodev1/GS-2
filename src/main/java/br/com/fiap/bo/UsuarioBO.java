package br.com.fiap.bo;

import br.com.fiap.dao.UsuarioDAO;
import br.com.fiap.to.UsuarioTO;

import java.util.ArrayList;

public class UsuarioBO {
    private UsuarioDAO usuarioDAO;

    public ArrayList<UsuarioTO> findAll() {
        usuarioDAO = new UsuarioDAO();
        // aqui se implementa a regra de negócios
        return usuarioDAO.findAll();
    }

    public UsuarioTO findByCodigo(Long codigo) {
        usuarioDAO = new UsuarioDAO();
        // aqui se implementa a regra de negócios
        return usuarioDAO.findByCodigo(codigo);
    }

    public UsuarioTO save(UsuarioTO usuario) {
        usuarioDAO = new UsuarioDAO();
        // aqui se implementa a regra de negócios
        return usuarioDAO.save(usuario);
    }

    public boolean delete(Long codigo) {
        usuarioDAO = new UsuarioDAO();
        // aqui se implementa a regra de negócios
        return usuarioDAO.delete(codigo);
    }

    public UsuarioTO update(UsuarioTO usuario) {
        usuarioDAO = new UsuarioDAO();
        // aqui se implementa a regra de negócios
        return usuarioDAO.update(usuario);
    }
}
