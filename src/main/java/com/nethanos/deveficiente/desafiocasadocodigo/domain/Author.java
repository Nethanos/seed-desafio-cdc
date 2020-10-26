package com.nethanos.deveficiente.desafiocasadocodigo.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import java.util.Date;
import java.util.Random;
import java.util.UUID;

@Entity
public class Author {
    @Id
    private String id;

    @NotBlank
    private String name;

    @NotBlank
    @Email
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
        this.id = UUID.randomUUID().toString();
        this.createdAt = new Date();
    }


    public void setId(String id) {
        this.id = id;
    }

    @Id
    public String getId() {
        return id;
    }

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

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }
}
