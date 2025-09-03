package br.com.murillo.ecommerce.service.produto;

import br.com.murillo.ecommerce.dao.ProdutoDAO;
import br.com.murillo.ecommerce.model.Categoria;
import br.com.murillo.ecommerce.model.Produto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProdutoServiceImpl implements IProdutoService {

    @Autowired
    private ProdutoDAO produtoDAO;

    @Override
    public Produto cadastrarNovo(Produto produto) {
        return produtoDAO.save(produto);
    }

    @Override
    public Produto atualizar(Produto produto) {
        return produtoDAO.save(produto);
    }

    @Override
    public List<Produto> recuperarTodos() {
        return produtoDAO.findByOrderByNomeAsc();
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
