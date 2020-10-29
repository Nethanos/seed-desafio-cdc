package com.nethanos.deveficiente.desafiocasadocodigo.controllers;

import com.nethanos.deveficiente.desafiocasadocodigo.domain.Author;
import com.nethanos.deveficiente.desafiocasadocodigo.requests.NewAuthorRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.Objects;

@RestController
public class AuthorController {

    @PersistenceContext
    EntityManager em;

    @PostMapping("/author")
    @Transactional
    public ResponseEntity createAuthor(@Valid @RequestBody NewAuthorRequest authorRequest){

        Author author = authorRequest.toEntity();

        em.persist(author);
        if(!Objects.isNull(author.getId())) {
            return  ResponseEntity.status(HttpStatus.CREATED).body(author.getId().toString());
        }

        return  ResponseEntity.status(HttpStatus.BAD_REQUEST).build();

    }

}
