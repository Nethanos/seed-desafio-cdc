package com.nethanos.deveficiente.desafiocasadocodigo.requests;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.nethanos.deveficiente.desafiocasadocodigo.domain.Author;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class NewAuthorRequest {

    private String name;

    private String email;

    private String description;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public Author toEntity(NewAuthorRequest request) {
        return new Author(request.getName(), request.getEmail(), request.getDescription());
    }
}
