package com.github.barbarastefany.dslist;

import com.github.barbarastefany.dslist.dto.GameDTO;
import com.github.barbarastefany.dslist.dto.GameMinDTO;
import com.github.barbarastefany.dslist.exceptions.GameNotFoundException;
import com.github.barbarastefany.dslist.service.GameService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(MockitoExtension.class)
public class GameControllerTest {

    @Mock
    private GameService gameService;

    @BeforeEach
    void setUp() {
    }

    @Test
    @DisplayName("Testa o método findAll")
    void testFindAll() {
        Mockito.when(gameService.findAll())
                .thenReturn(List.of(
                        new GameMinDTO(),
                        new GameMinDTO(),
                        new GameMinDTO(),
                        new GameMinDTO()));
        List<GameMinDTO> list = gameService.findAll();
        assertEquals(4, list.size());
    }

    @Test
    @DisplayName("Testa o método findById")
    void testFindById() {
        Mockito.when(gameService.findById(1L)).thenReturn(new GameDTO());
        GameDTO game = new GameDTO(); // Cria um novo objeto GameDTO e seta seus atributos das linhas 46 a 54
        game.setId(1L);
        game.setTitle("The Legend of Zelda: Ocarina of Time");
        game.setYear(1998);
        game.setGenre("Action-adventure");
        game.setPlatforms("Nintendo 64");
        game.setScore(99.0);
        game.setImgUrl("https://www.nintendo.com.br/wp-content/uploads/2021/07/Logo-Zelda-Ocarina-of-Time.png");
        game.setShortDescription("The Legend of Zelda: Ocarina of Time é um jogo eletrônico de ação-aventura desenvolvido pela Nintendo EAD e publicado pela Nintendo para o Nintendo 64.");
        game.setLongDescription("Ocarina of Time segue um jovem chamado Link, que é guiado pela árvore Deku, a guardiã da floresta de Kokiri. Kokiri é o lar de crianças que nunca envelhecem, e Link é o único sem uma fada guardiã.");
        Mockito.when(gameService.findById(1L))
                .thenReturn(game);
        ;
        game = gameService.findById(1L);
        assertEquals(1L, game.getId());
    }

    @Test
    @DisplayName("Verifica se retorna erro ao buscar um jogo inexistente")
    void testFindByIdError() {
        Mockito.when(gameService.findById(1L)).thenThrow(new GameNotFoundException());
        assertThrows(GameNotFoundException.class, () -> gameService.findById(1L));
    }
}
