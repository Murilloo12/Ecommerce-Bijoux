package br.com.murillo.ecommerce.service.cliente;

import br.com.murillo.ecommerce.model.Cliente;

import java.util.List;

public interface IClienteService {

    public Cliente cadastrarNovoCliente(Cliente cliente);

    public Cliente alterarCliente(Cliente cliente);

    public Cliente recuperarClientePeloId(Integer id);

    public Cliente recuperarClientePeloTelefone(String telefone);

    public List<Cliente> recuperarTodosClientes();
}
