package br.com.murillo.ecommerce.dao;

import br.com.murillo.ecommerce.model.Categoria;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CategoriaDAO extends CrudRepository<Categoria,Integer> {

    public List<Categoria> findAllByOrderByNomeAsc();
}
