package br.com.murillo.ecommerce.service.variante;

import br.com.murillo.ecommerce.model.Produto;
import br.com.murillo.ecommerce.model.Variante;

import java.util.List;

public interface IVarianteService {

    public Variante adiconarNova(Variante variante);

    public Variante alterarDados(Variante variante);

    public List<Variante> recuperarPorProduto(Produto produto);

    public Variante recuperarPeloId(Integer id);
}
