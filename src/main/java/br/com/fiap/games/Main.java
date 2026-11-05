package br.com.fiap.games;

import br.com.fiap.games.dao.CategoriaDao;
import br.com.fiap.games.dao.GameDao;
import br.com.fiap.games.model.Categoria;
import br.com.fiap.games.model.Game;
import br.com.fiap.games.utils.Conexao;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.time.LocalDate;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        EntityManager em = Conexao.getEntityManager();

        //cadastrar(em);
        //pesquisar(em);
        //listarTodosOsGames(em);
        //buscarGamePeloNome(em);
        //buscarGamePorFaixaDeValores(em);
        listarCategoriaPorId(em);


        em.close();
    }

    public static void buscarGamePorFaixaDeValores(EntityManager em){
        GameDao gameDao = new GameDao(em);
        List<Game> games = gameDao.buscarGamePorFaixaDeValores(150.00,300.00);

        for (Game game : games) {
            System.out.println(game);
            System.out.println("--------------------------");
        }
    }

    public static void buscarGamePeloNome(EntityManager em){
        GameDao gameDao = new GameDao(em);
        List<Game> games = gameDao.buscarGamePeloNome("mega man 2".toUpperCase());

        for (Game game : games){
            System.out.println(game);
            System.out.println("--------------------------");
        }
    }

    public static void listarTodosOsGames(EntityManager em){
        GameDao gameDao = new GameDao(em);
        List<Game> games = gameDao.listarTodosOsGames();

        for (Game game : games){
            System.out.println(game);
            System.out.println("-------------------------");
        }
    }

    public static void listarCategoriaPorId(EntityManager em){
        CategoriaDao categoriaDao = new CategoriaDao(em);
        Categoria categoria = new Categoria();
        categoria.setId(1L);
        Categoria categoriaEncontrada = categoriaDao.buscarCategoriaPorId(categoria);
        System.out.println(categoriaEncontrada.toString());
    }

    public static void pesquisar(EntityManager em) {

        GameDao gameDao = new GameDao(em);
        Game game = new Game();
        game.setId(3L);
        Game gameEncontrado = gameDao.buscarGamePeloId(game);

        if (gameEncontrado != null) {
            System.out.println(gameEncontrado.toString());
        } else {
            System.out.println("Game não encontrado!");
        }

    }

    public static void cadastrar(EntityManager em) {
        Categoria categoria = new Categoria();
        categoria.setId(1L);

        //CategoriaDao categoriaDao = new CategoriaDao(em);
        em.getTransaction().begin();
        //categoriaDao.salvar(categoria);

        Game game1 = new Game();

        game1.setTitulo("Streets of Rage");
        game1.setCategoria(categoria);
        game1.setDataLancamento(LocalDate.of(1991,7,1));
        game1.setFinalizado(true);
        game1.setProdutora("SEGA");
        game1.setValor(99.99);

        GameDao gameDao = new GameDao(em);

        gameDao.salvar(game1);
        em.getTransaction().commit();
        em.close();
    }

}
