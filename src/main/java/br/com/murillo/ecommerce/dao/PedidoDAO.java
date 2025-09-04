package br.com.murillo.ecommerce.dao;

import br.com.murillo.ecommerce.dto.FaturamentoMensal;
import br.com.murillo.ecommerce.model.Pedido;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PedidoDAO extends CrudRepository<Pedido, Integer> {

    public List<Pedido> findAllByStatus(Integer status);

    @Query("SELECT new "
            + " br.com.murillo.ecommerce.dto.FaturamentoMensal(month(p.dataPedido), sum(p.valorTotal)) "
            + " FROM Pedido p "
            + " WHERE year(p.dataPedido) = :ano "
            + " GROUP BY month(p.dataPedido) ")
    public List<FaturamentoMensal> recuperarFaturamento(@Param("ano") Integer ano);

}
