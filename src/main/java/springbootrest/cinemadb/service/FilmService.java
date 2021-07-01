package springbootrest.cinemadb.service;

import springbootrest.cinemadb.model.Film;
import java.util.List;

public interface FilmService {

    void createFilm(Film film);
    List<Film> readAll();
    Film read(int id);
    boolean update(Film client, int id);
    boolean delete(int id);

}
