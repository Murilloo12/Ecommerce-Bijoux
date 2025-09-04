package br.com.murillo.ecommerce.controller;

import br.com.murillo.ecommerce.model.Usuario;
import br.com.murillo.ecommerce.security.ECToken;
import br.com.murillo.ecommerce.service.usuario.IUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class UsuarioController {

    @Autowired
    private IUsuarioService usuarioService;

    @PostMapping("/usuarios")
    public ResponseEntity<Usuario> cadastrarNovo(@RequestBody Usuario usuario) {
        Usuario res = usuarioService.cadastrarNovo(usuario);
        if (res != null) {
            return ResponseEntity.status(201).body(res);
        }
        return ResponseEntity.badRequest().build();
    }

    @PutMapping("/usuarios/{id}")
    public ResponseEntity<Usuario> alterarDados(@PathVariable Integer id, @RequestBody Usuario usuario) {
        usuario.setIdUsuario(id);
        Usuario res = usuarioService.alterarDados(usuario);
        if (res != null) {
            return ResponseEntity.ok(res);
        }
        return ResponseEntity.badRequest().build();
    }

    @PostMapping("/login")
    public ResponseEntity<ECToken> realizarLogin(@RequestBody Usuario usuario) {
        ECToken token = usuarioService.fazerLogin(usuario.getLogin(),usuario.getSenha());
        if (token != null) {
            return ResponseEntity.ok(token);
        }
        return ResponseEntity.status(403).build();
    }
}
