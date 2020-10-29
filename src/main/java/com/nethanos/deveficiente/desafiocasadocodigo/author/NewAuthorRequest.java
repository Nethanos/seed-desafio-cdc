package com.nethanos.deveficiente.desafiocasadocodigo.author;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class NewAuthorRequest {

    @NotBlank(message = "{name.not.blank}")
    private String name;

    @Email
    private String email;

    @Size(max = 400)
    private String description;

    public String getDescription() {
        return description;
    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }

    public Author toEntity() {
        return new Author(this.getName(), this.getEmail(), this.getDescription());
    }
}
