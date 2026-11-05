package br.com.fiap.games.dao;

import br.com.fiap.games.model.Categoria;
import jakarta.persistence.EntityManager;

public class CategoriaDao {

    private EntityManager em;

    public CategoriaDao(EntityManager em) {
        this.em = em;
    }

    public void salvar(Categoria categoria) {
        em.persist(categoria);
    }

    public Categoria buscarCategoriaPorId(Categoria categoria) {
        return em.find(Categoria.class, categoria.getId());
    }
}