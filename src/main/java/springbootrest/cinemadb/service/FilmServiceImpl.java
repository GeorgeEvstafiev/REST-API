package springbootrest.cinemadb.service;

import org.springframework.stereotype.Service;
import springbootrest.cinemadb.model.Film;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class FilmServiceImpl  implements FilmService{

    private static final AtomicInteger FILM_ID_HOLDER = new AtomicInteger();

    private static final Map<Integer, Film> FILM_REPOSITORY_MAP = new HashMap<>();

    @Override
    public void createFilm(Film film) {
        final int filmId = FILM_ID_HOLDER.incrementAndGet();
        film.setId(filmId);
        FILM_REPOSITORY_MAP.put(filmId, film);
    }

    @Override
    public List<Film> readAll() {
        return new ArrayList<>(FILM_REPOSITORY_MAP.values());
    }

    @Override
    public Film read(int id) {
        return FILM_REPOSITORY_MAP.get(id);
    }

    @Override
    public boolean update(Film film, int id) {
        if (FILM_REPOSITORY_MAP.containsKey(id)) {
            film.setId(id);
            FILM_REPOSITORY_MAP.put(id, film);
            return true;
        }
        return false;
    }

    @Override
    public boolean delete(int id) {
        return FILM_REPOSITORY_MAP.remove(id) != null;
    }
}
