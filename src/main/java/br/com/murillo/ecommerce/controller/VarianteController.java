package br.com.murillo.ecommerce.controller;

import br.com.murillo.ecommerce.model.Produto;
import br.com.murillo.ecommerce.model.Variante;
import br.com.murillo.ecommerce.service.variante.IVarianteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class VarianteController {

    @Autowired
    private IVarianteService varianteService;

    @PostMapping("/variantes")
    public ResponseEntity<Variante> adicionar(@RequestBody Variante variante) {
        Variante v = varianteService.adiconarNova(variante);
        if (v != null) {
            return ResponseEntity.ok().body(v);
        }
        return ResponseEntity.badRequest().build();
    }

    @PutMapping("/variantes/{id}")
    public ResponseEntity<Variante> modificar(@RequestBody Variante variante, @PathVariable Integer id) {
        variante.setId(id);
        Variante v = varianteService.alterarDados(variante);
        if (v != null) {
            return ResponseEntity.ok().body(v);
        }
        return ResponseEntity.badRequest().build();
    }

    @GetMapping("/variantes/{id}")
    public ResponseEntity<Variante> recuperarPeloId(@PathVariable Integer id) {
        Variante v = varianteService.recuperarPeloId(id);
        if (v != null) {
            return ResponseEntity.ok().body(v);
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/variantes")
    public ResponseEntity<List<Variante>> recuperarPeloProduto(@RequestParam(name = "idproduto") Integer id) {
        Produto p = new Produto();
        p.setId(id);
        return ResponseEntity.ok(varianteService.recuperarPorProduto(p));
    }
}
