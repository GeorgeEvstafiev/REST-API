package springbootrest.controllers;

import org.springframework.http.HttpStatus;
import springbootrest.model.Film;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import springbootrest.service.FilmService;

import java.net.URI;
import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping("/films")
public class FilmController {

    /**
     * (получение по ID + ,
     * получение по параметрам фильтра ???,
     * получение всех сущностей + ,
     * создание новой сущности + ,
     * изменение сущности +,
     * удаление сущности по ID +)
     */

    private FilmService filmService;

    @Autowired
    public FilmController(FilmService filmService) {
        this.filmService = filmService;
    }

    // Создать запись
    @PostMapping(value = "/films")
    public ResponseEntity<?> createItem(@RequestBody Film film) {
        filmService.createFilm(film);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    // Получить все записи
    @GetMapping(value = "/films")
    public ResponseEntity<List<Film>> read() {
        final List<Film> films = filmService.readAll();

        return films != null &&  !films.isEmpty()
                ? new ResponseEntity<>(films, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    // Получить запись по id
    @GetMapping(value = "/films/{id}")
    public ResponseEntity<Film> read(@PathVariable(name = "id") int id) {
        final Film film = filmService.read(id);

        return film != null
                ? new ResponseEntity<>(film, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    // Обновить запись
    @PutMapping(value = "/films/{id}")
    public ResponseEntity<?> update(@PathVariable(name = "id") int id, @RequestBody Film film) {
        final boolean updated = filmService.update(film, id);

        return updated
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }

    // Удалить запись по id
    @DeleteMapping(value = "/films/{id}")
    public ResponseEntity<?> delete(@PathVariable(name = "id") int id) {
        final boolean deleted = filmService.delete(id);

        return deleted
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }




   /* @Autowired
    private FilmRepository filmRepository;

    @RequestMapping(method = RequestMethod.OPTIONS)
    ResponseEntity<?> options() {
        return ResponseEntity
                .ok()
                .allow(HttpMethod.GET, HttpMethod.POST,
                        HttpMethod.HEAD, HttpMethod.OPTIONS,
                        HttpMethod.PUT, HttpMethod.DELETE)
                .build();
    }

    // Получить все записи
    @GetMapping
    public ResponseEntity<Collection<Film>> getItemsCollection() {
        return ResponseEntity.ok(this.filmRepository.findAll());
    }

    // Получить запись по id
    @GetMapping(value = "/{id}")
    public ResponseEntity<Film> getItemById(@PathVariable Long id) throws FilmNotFoundException {
        return this.filmRepository.findById(id).map(ResponseEntity::ok)
                .orElseThrow(() -> new FilmNotFoundException(id));
    }

    // Создать запись
    @PostMapping
    public ResponseEntity<Film> createItem(@RequestBody Film f) {
        Film film = this.filmRepository.save(new Film(f.getId(), f.getFilm_name(), f.getAuthor_name()));
        URI uri = MvcUriComponentsBuilder.fromController(getClass()).path("/{id}")
                .buildAndExpand(film.getId()).toUri();
        return ResponseEntity.created(uri).body(film);
    }

    // Удалить запись по id
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> deleteItem(@PathVariable Long id) throws FilmNotFoundException {
       return this.filmRepository.findById(id).map(c -> {
           filmRepository.delete(c);
           return ResponseEntity.noContent().build();
       }).orElseThrow(() -> new FilmNotFoundException(id));
    }

    // Обновить запись
    @PutMapping(value = "/{id}")
    public ResponseEntity<Film> updateItem(@PathVariable Long id, @RequestBody Film filmDetails) throws FilmNotFoundException {
        return this.filmRepository
                .findById(id)
                .map(
                        existing -> {
                            Film film = this.filmRepository.save(new Film(existing.getId(), existing.getFilm_name(), existing.getAuthor_name()));
                            URI selfLink = URI.create(ServletUriComponentsBuilder.fromCurrentRequest().toUriString());
                            return ResponseEntity.created(selfLink).body(film);
                        }
                ).orElseThrow(() -> new FilmNotFoundException(id));
    }

    // Подтверждает существование ресурса
    @RequestMapping(value = "/{id}", method = RequestMethod.HEAD)
    public ResponseEntity<?> head(@PathVariable Long id) throws FilmNotFoundException{
        return this.filmRepository.findById(id)
                .map(exist -> ResponseEntity.noContent().build())
                .orElseThrow(() -> new FilmNotFoundException(id));
    }*/
}
