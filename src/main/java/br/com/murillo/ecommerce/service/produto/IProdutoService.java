package br.com.murillo.ecommerce.service.produto;

import br.com.murillo.ecommerce.model.Categoria;
import br.com.murillo.ecommerce.model.Produto;

import java.util.List;

public interface IProdutoService {

    public Produto cadastrarNovo(Produto produto);

    public Produto atualizar(Produto produto);

    public List<Produto> recuperarTodos();

    public List<Produto> recuperarPorPalavraChave(String palavraChave);

    public Produto buscarPorId(Integer id);

    public List<Produto> buscarPorCategoria(Categoria categoria);
}
