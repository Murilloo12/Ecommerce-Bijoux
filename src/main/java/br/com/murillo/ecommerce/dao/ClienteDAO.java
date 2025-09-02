package br.com.murillo.ecommerce.dao;

import br.com.murillo.ecommerce.model.Cliente;
import org.springframework.data.repository.CrudRepository;

public interface ClienteDAO extends CrudRepository<Cliente, Integer> {

    public Cliente findByTelefone(String telefone);
}
