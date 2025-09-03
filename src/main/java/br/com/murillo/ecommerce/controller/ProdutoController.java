package br.com.murillo.ecommerce.controller;

import br.com.murillo.ecommerce.model.Categoria;
import br.com.murillo.ecommerce.model.Produto;
import br.com.murillo.ecommerce.service.produto.IProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProdutoController {

    @Autowired
    private IProdutoService produtoService;

    @GetMapping("/produtos")
    public ResponseEntity<List<Produto>> recuperarTodos() {
        return ResponseEntity.ok(produtoService.recuperarTodos());
    }

    @GetMapping("/produtos/{id}")
    public ResponseEntity<Produto> recuperarPeloId(@PathVariable Integer id) {
        Produto res = produtoService.buscarPorId(id);
        if (res != null) {
            return ResponseEntity.ok(res);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping("/produtos")
    public ResponseEntity<Produto> inserirNovo(@RequestBody Produto produto) {
        Produto res = produtoService.cadastrarNovo(produto);
        if (res != null) {
            return ResponseEntity.status(201).body(res);
        }
        return ResponseEntity.badRequest().build();
    }

    @PutMapping("/produtos/{id}")
    public ResponseEntity<Produto> alterarProduto(@PathVariable Integer id, @RequestBody Produto produto) {
        produto.setId(id);
        Produto res = produtoService.atualizar(produto);
        if (res != null) {
            return ResponseEntity.ok(res);
        }
        return ResponseEntity.badRequest().build();
    }

    @GetMapping("/produtos/search")
    public ResponseEntity<List<Produto>> recuperarPorPalavraChave(@RequestParam(name = "key") String key) {
        List<Produto> lista = produtoService.recuperarPorPalavraChave(key);
        if (lista.size() > 0) {
            return ResponseEntity.ok(lista);
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/produtos/categoria/{id}")
    public ResponseEntity<List<Produto>> recuperarPorCategoria(@PathVariable Integer id) {
        Categoria categoria = new Categoria();
        categoria.setId(id);
        return ResponseEntity.ok(produtoService.buscarPorCategoria(categoria));
    }
}
