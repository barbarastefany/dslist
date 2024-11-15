package com.github.barbarastefany.dslist.dto;

import com.github.barbarastefany.dslist.entities.Game;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

@NoArgsConstructor
@Data
public class GameDTO {

    private Long id;
    private String title;
    private Integer year;
    private String genre;
    private String platforms;
    private Double score;
    private String imgUrl;
    private String shortDescription;
    private String longDescription;

    public GameDTO(Game entity) {
        BeanUtils.copyProperties(entity, this);
    }
}
