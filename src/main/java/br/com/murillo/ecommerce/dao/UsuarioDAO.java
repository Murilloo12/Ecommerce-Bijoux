package br.com.murillo.ecommerce.dao;

import br.com.murillo.ecommerce.model.Usuario;
import org.springframework.data.repository.CrudRepository;

public interface UsuarioDAO  extends CrudRepository<Usuario, Integer> {

    public Usuario findByLogin(String login);
}
