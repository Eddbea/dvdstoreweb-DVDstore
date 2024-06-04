package com.mycompany.dvdstore.dvdstoreweb.form;


import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class MovieForm {

    @NotBlank(message = "Veuillez entrer un titre")
    @Size(max = 20, message="Entrez un titre de 20 caracteres au plus")
    private String title;

    @NotBlank(message = "Veuillez choisir un genre")
    private String genre;

    private Long id;

    @Size(min=1, max=255, message = "Entrez une description de 255 caracteres au plus")
    private String description;

    @Size(max=20)
    private String lastName;

    @NotBlank
    @Size(max=20)
    private String firstName;

    public @NotBlank @Size(max = 20) String getFirstName() {
        return firstName;
    }

    public void setFirstName(@NotBlank @Size(max = 20) String firstName) {
        this.firstName = firstName;
    }

    public @Size(max = 20) String getLastName() {
        return lastName;
    }

    public void setLastName(@Size(max = 20) String name) {
        this.lastName = name;
    }


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