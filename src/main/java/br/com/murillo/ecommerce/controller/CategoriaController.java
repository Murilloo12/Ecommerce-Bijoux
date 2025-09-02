package br.com.murillo.ecommerce.controller;

import br.com.murillo.ecommerce.model.Categoria;
import br.com.murillo.ecommerce.service.categoria.ICategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CategoriaController {

    @Autowired
    private ICategoriaService categoriaService;

    @GetMapping("/categorias")
    public ResponseEntity<List<Categoria>> recuperarTodas() {
        return ResponseEntity.ok(categoriaService.listarTudo());
    }

    @PostMapping("/categorias")
    public ResponseEntity<Categoria> adicionarNova(@RequestBody Categoria categoria) {
        Categoria result = categoriaService.criarNova(categoria);
        if (result != null) {
            return ResponseEntity.status(201).body(result);
        }
        return ResponseEntity.badRequest().build();
    }

    @PutMapping("/categorias/{id}")
    public ResponseEntity<Categoria> atualizarCategoria(@PathVariable Integer id, @RequestBody Categoria categoria) {
        categoria.setId(id);
        Categoria result = categoriaService.atualizar(categoria);
        if (result != null) {
            return ResponseEntity.ok(result);
        }
        return ResponseEntity.badRequest().build();
    }

    @DeleteMapping("/categorias/{id}")
    public ResponseEntity<?> removerCategoria(@PathVariable Integer id) {
        categoriaService.apagarCategoria(id);
        return ResponseEntity.ok("Removed");
    }

}
