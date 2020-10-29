package com.nethanos.deveficiente.desafiocasadocodigo.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import java.util.Date;
import java.util.UUID;

@Entity
public class Author {
    @Id
    private UUID id;

    private String name;

    private String email;

    private String description;

    private Date createdAt;

    @Deprecated
    public Author() {

    }

    public Author(@NotBlank String name,
                  @Email String email,
                  @Max(400) String description) {
        this.name = name;
        this.email = email;
        this.description = description;
    }

    @PrePersist
    private void configureOneness() {
        this.id = UUID.randomUUID();
        this.createdAt = new Date();
    }


    public void setId(UUID id) {
        this.id = id;
    }

    @Id
    public UUID getId() {
        return id;
    }

}