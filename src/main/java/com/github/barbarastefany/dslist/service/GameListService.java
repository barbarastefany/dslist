package com.github.barbarastefany.dslist.service;

import com.github.barbarastefany.dslist.dto.GameListDTO;
import com.github.barbarastefany.dslist.entities.GameList;
import com.github.barbarastefany.dslist.projection.GameMinProjection;
import com.github.barbarastefany.dslist.repository.GameListRepository;
import com.github.barbarastefany.dslist.repository.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GameListService {

    @Autowired
    private GameListRepository gameListRepository;

    @Autowired
    private GameRepository gameRepository;

    @Transactional(readOnly = true)
    public List<GameListDTO> findAll() {
        List<GameList> result = gameListRepository.findAll();
        return result.stream().map(x -> new GameListDTO(x)).toList(); // Transforma a lista de GameList em uma lista de GameListDTO
    }

    @Transactional
    public void move(Long listId, int sourceIndex, int destinationIndex) {
        List<GameMinProjection> list = gameRepository.searchByList(listId);
        GameMinProjection game = list.remove(sourceIndex);
        list.add(destinationIndex, game);

        int min = sourceIndex < destinationIndex ? sourceIndex : destinationIndex;
        int max = sourceIndex < destinationIndex ? destinationIndex : sourceIndex;

        for (int i = min; i <= max; i++) {
            gameListRepository.updateBelongingPosition(listId, list.get(i).getId(), i);
        }
    }

}
