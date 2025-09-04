package br.com.murillo.ecommerce.service.usuario;

import br.com.murillo.ecommerce.dao.UsuarioDAO;
import br.com.murillo.ecommerce.model.Usuario;
import br.com.murillo.ecommerce.security.ECToken;
import br.com.murillo.ecommerce.security.ECTokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Component
public class UsuarioServiceImpl implements IUsuarioService{

    @Autowired
    private UsuarioDAO usuarioDAO;

    @Override
    public Usuario cadastrarNovo(Usuario usuario) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String novaSenha = encoder.encode(usuario.getSenha());
        usuario.setSenha(novaSenha);
        return usuarioDAO.save(usuario);
    }

    @Override
    public Usuario alterarDados(Usuario usuario) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String novaSenha = encoder.encode(usuario.getSenha());
        usuario.setSenha(novaSenha);
        return usuarioDAO.save(usuario);
    }

    @Override
    public ECToken fazerLogin(String login, String senha) {
        Usuario usuario = usuarioDAO.findByLogin(login);
        if (usuario != null) {
            BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
            if(encoder.matches(senha, usuario.getSenha())) {
                return ECTokenUtil.generateToken(usuario);
            }
        }
        return null;
    }
}
