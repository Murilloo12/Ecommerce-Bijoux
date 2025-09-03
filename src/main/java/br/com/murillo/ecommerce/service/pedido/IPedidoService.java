package br.com.murillo.ecommerce.service.pedido;

import br.com.murillo.ecommerce.model.Cliente;
import br.com.murillo.ecommerce.model.Pedido;

import java.util.List;

public interface IPedidoService {
    public Pedido criarNovoPedido(Pedido pedido);

    public Pedido alterarDados(Pedido pedido);

    public List<Pedido> recuperarTodos();

    public Pedido recuperarPeloNumero(Integer numPedido);

    public List<Pedido> recuperarPorStatus(Integer status);
}
