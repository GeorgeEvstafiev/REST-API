package springbootrest.cinemadb.model;

import javax.validation.constraints.NotNull;

public class Film {

    private int id;

    @NotNull
    private String film_name;

    @NotNull
    private String author_name;

    public Film() {
        super();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFilm_name() {
        return film_name;
    }

    public void setFilm_name(String film_name) {
        this.film_name = film_name;
    }

    public String getAuthor_name() {
        return author_name;
    }

    public void setAuthor_name(String author_name) {
        this.author_name = author_name;
    }

    public Film(int id, String film_name, String author_name) {
        super();
        this.id = id;
        this.film_name = film_name;
        this.author_name = author_name;
    }

}
