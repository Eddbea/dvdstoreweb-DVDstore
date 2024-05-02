package com.mycompany.dvdstore.dvdstoreweb.controller.form;

import jakarta.validation.constraints.Size;

public class MovieForm {
    @Size(min=1, max=20)
    private String title;
    private String genre;
    private Long id;
    @Size(min=1, max=255)
    private String summary;

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
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