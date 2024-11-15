package com.github.barbarastefany.dslist.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Embeddable // 2 tributos que formam a chave primária
@NoArgsConstructor
@AllArgsConstructor
@Data
public class BelongingPK {

    @ManyToOne
    @JoinColumn(name = "game_id")
    private Game game;

    @ManyToOne
    @JoinColumn(name = "list_id")
    private GameList list;

}
