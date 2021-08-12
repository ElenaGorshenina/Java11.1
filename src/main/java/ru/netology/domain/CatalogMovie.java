package ru.netology.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.netology.manager.MovieManager;

@AllArgsConstructor
public class CatalogMovie {
    private int id;
    private int movieId;
    private String movieUrlPicture;
    private String movieName;
    private String movieGenre;
    private String dataPremiere;

}
