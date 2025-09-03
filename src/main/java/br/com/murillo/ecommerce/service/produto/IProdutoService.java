package br.com.murillo.ecommerce.service.produto;

import br.com.murillo.ecommerce.model.Categoria;
import br.com.murillo.ecommerce.model.Produto;
import org.springframework.data.domain.Page;

import java.util.List;

public interface IProdutoService {

    public Produto cadastrarNovo(Produto produto);

    public Produto atualizar(Produto produto);

    public Page<Produto> recuperarTodos(int numPagina);

    public List<Produto> recuperarPorPalavraChave(String palavraChave);

    public Produto buscarPorId(Integer id);

    public List<Produto> buscarPorCategoria(Categoria categoria);
}
