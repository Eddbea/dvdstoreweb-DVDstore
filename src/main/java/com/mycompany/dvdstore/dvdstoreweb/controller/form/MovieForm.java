package com.mycompany.dvdstore.dvdstoreweb.controller.form;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class MovieForm {

    @NotBlank(message = "Veuillez entrer un titre")
    @Size(max = 20, message="Entrez un titre de 20 caracteres au plus")
    private String title;
    @NotBlank(message = "Veuillez choisir un genre")
    private String genre;
    private Long id;
    @Size(min=1, max=255, message = "Entrez une description de 255 caracteres au plus")
    private String description;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }
}