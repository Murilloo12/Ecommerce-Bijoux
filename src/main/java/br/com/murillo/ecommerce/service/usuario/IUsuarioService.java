package br.com.murillo.ecommerce.service.usuario;

import br.com.murillo.ecommerce.model.Usuario;
import br.com.murillo.ecommerce.security.ECToken;

public interface IUsuarioService {

    public Usuario cadastrarNovo(Usuario usuario);
    public Usuario alterarDados(Usuario usuario);
    public ECToken fazerLogin(String login, String senha);
}
