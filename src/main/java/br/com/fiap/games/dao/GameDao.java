package br.com.fiap.games.dao;

import br.com.fiap.games.model.Game;
import jakarta.persistence.EntityManager;

public class GameDao {

    private EntityManager em;

    public GameDao(EntityManager em){
        this.em = em;
    }

    public void salvar(Game game){
        em.persist(game);
    }
}
