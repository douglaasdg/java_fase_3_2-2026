package br.com.fiap.games;

import br.com.fiap.games.model.Game;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.time.LocalDate;

public class Main {

    public static void main(String[] args) {

        Game game1 = new Game();
        game1.setTitulo("Megaman 1");
        game1.setCategoria("Plataforma");
        game1.setDataLancamento(LocalDate.of(1987,12,1));
        game1.setFinalizado(true);
        game1.setProdutora("Capcom");
        game1.setValor(128.00);

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("games");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();
        em.persist(game1);
        em.getTransaction().commit();
        em.close();
    }

}
