package br.com.murillo.ecommerce.controller;

import br.com.murillo.ecommerce.model.Pedido;
import br.com.murillo.ecommerce.service.pedido.IPedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PedidoController {

    @Autowired
    private IPedidoService pedidoService;

    @PostMapping("/pedidos")
    public ResponseEntity<Pedido> inserirNovo(@RequestBody Pedido pedido) {
        Pedido result = pedidoService.criarNovoPedido(pedido);
        if (result != null) {
            return ResponseEntity.ok().body(result);
        }
        return ResponseEntity.badRequest().build();
    }

    @GetMapping("/pedidos")
    public ResponseEntity<List<Pedido>> recuperarTodos() {
        return ResponseEntity.ok(pedidoService.recuperarTodos());
    }

    @GetMapping("/pedidos/{id}")
    public ResponseEntity<Pedido> recuperarPeloId(@PathVariable Integer id) {
        Pedido result = pedidoService.recuperarPeloNumero(id);
        if (result != null) {
            return ResponseEntity.ok(result);
        }
        return ResponseEntity.notFound().build();
    }
}
