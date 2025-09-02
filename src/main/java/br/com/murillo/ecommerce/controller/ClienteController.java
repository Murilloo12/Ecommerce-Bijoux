package br.com.murillo.ecommerce.controller;

import br.com.murillo.ecommerce.model.Cliente;
import br.com.murillo.ecommerce.service.cliente.IClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ClienteController {

    @Autowired
    private IClienteService clienteService;

    @GetMapping("/clientes")
    public ResponseEntity<List<Cliente>> getAll() {
        return ResponseEntity.ok(clienteService.recuperarTodosClientes());
    }

    @GetMapping("/cliente/{id}")
    public ResponseEntity<Cliente> getById(@PathVariable Integer id) {
        Cliente result = clienteService.recuperarClientePeloId(id);
        if (result != null) {
            return ResponseEntity.ok(result);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping("/clientes")
    public ResponseEntity<Cliente> insertNew(@RequestBody Cliente cliente) {
        try {
            Cliente result = clienteService.cadastrarNovoCliente(cliente);
            if (result != null) {
                return ResponseEntity.status(201).body(result);
            }
        } catch (Exception ex) {
            System.out.println("LOG - Erro ao cadastrar - " + ex.getMessage());
        }
        return ResponseEntity.badRequest().build();
    }

    @PutMapping("/clientes/{id}")
    public ResponseEntity<Cliente> update(@PathVariable Integer id, @RequestBody Cliente cliente) {
        cliente.setId(id);
        try {
            Cliente result = clienteService.alterarCliente(cliente);
            if (result != null) {
                return ResponseEntity.ok(result);
            }
        } catch (Exception ex) {
            System.out.println("LOG - Erro ao atualizar - " + ex.getMessage());
        }
        return ResponseEntity.badRequest().build();
    }

    @GetMapping("/clientes/busca")
    public ResponseEntity<Cliente> searchByPhone(@RequestParam(name = "telefone") String telefone) {
        Cliente result = clienteService.recuperarClientePeloTelefone(telefone);
        if (result != null) {
            return ResponseEntity.ok(result);
        }
        return ResponseEntity.notFound().build();
    }
}
