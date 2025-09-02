package br.com.murillo.ecommerce.service.categoria;

import br.com.murillo.ecommerce.dao.CategoriaDAO;
import br.com.murillo.ecommerce.model.Categoria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CategoriaServiceImpl implements ICategoriaService{

    @Autowired
    private CategoriaDAO categoriaDAO;

    @Override
    public Categoria criarNova(Categoria categoria) {
        return categoriaDAO.save(categoria);
    }

    @Override
    public Categoria atualizar(Categoria categoria) {
        return categoriaDAO.save(categoria);
    }

    @Override
    public List<Categoria> listarTudo() {
        return categoriaDAO.findAllByOrderByNomeAsc();
    }

    @Override
    public void apagarCategoria(Integer id) {
        categoriaDAO.deleteById(id);
    }

}
