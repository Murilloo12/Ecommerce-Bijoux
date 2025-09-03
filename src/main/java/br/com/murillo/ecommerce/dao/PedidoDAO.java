package br.com.murillo.ecommerce.dao;

import br.com.murillo.ecommerce.model.Pedido;
import br.com.murillo.ecommerce.model.Produto;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PedidoDAO extends CrudRepository<Pedido, Integer> {

    public List<Pedido> findAllByStatus(Integer status);
}
