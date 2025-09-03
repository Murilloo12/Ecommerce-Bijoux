package br.com.murillo.ecommerce.service.produto;

import br.com.murillo.ecommerce.dao.ProdutoDAO;
import br.com.murillo.ecommerce.model.Categoria;
import br.com.murillo.ecommerce.model.Produto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProdutoServiceImpl implements IProdutoService {

    @Autowired
    private ProdutoDAO produtoDAO;

    private static final int PAGE_SIZE = 5;

    @Override
    public Produto cadastrarNovo(Produto produto) {
        return produtoDAO.save(produto);
    }

    @Override
    public Produto atualizar(Produto produto) {
        return produtoDAO.save(produto);
    }

    @Override
    public Page<Produto> recuperarTodos(int numPagina) {
        System.out.println("numPagina: " + numPagina + "/" + PAGE_SIZE);
        Pageable pageable = PageRequest.of(numPagina - 1,PAGE_SIZE);
        return produtoDAO.findByOrderByNomeAsc(pageable);
    }

    @Override
    public List<Produto> recuperarPorPalavraChave(String palavraChave) {
        return produtoDAO.findByNomeContaining(palavraChave);
    }

    @Override
    public Produto buscarPorId(Integer id) {
        return produtoDAO.findById(id).orElse(null);
    }

    @Override
    public List<Produto> buscarPorCategoria(Categoria categoria) {
        return produtoDAO.findByCategoriasContaining(categoria);
    }
}
