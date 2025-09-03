package br.com.murillo.ecommerce.dao;

import br.com.murillo.ecommerce.model.Produto;
import br.com.murillo.ecommerce.model.Variante;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface VarianteDAO extends CrudRepository<Variante, Integer> {

    public List<Variante> findByProduto(Produto produto);
}
