package br.com.murillo.ecommerce.service.categoria;

import br.com.murillo.ecommerce.model.Categoria;

import java.util.List;

public interface ICategoriaService {

    public Categoria criarNova(Categoria categoria);
    public Categoria atualizar(Categoria categoria);
    public List<Categoria> listarTudo();
    public void apagarCategoria(Integer id);
}
