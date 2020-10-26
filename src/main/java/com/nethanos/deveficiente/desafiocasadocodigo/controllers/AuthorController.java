package com.nethanos.deveficiente.desafiocasadocodigo.controllers;

import com.nethanos.deveficiente.desafiocasadocodigo.domain.Author;
import com.nethanos.deveficiente.desafiocasadocodigo.requests.NewAuthorRequest;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@RestController
public class AuthorController {

    @PersistenceContext
    EntityManager em;

    @PostMapping("/author")
    @Transactional
    public @ResponseBody String createAuthor(@RequestBody NewAuthorRequest authorRequest){

        Author author = authorRequest.toEntity(authorRequest);

        em.persist(author);

        return  author.getId();

    }

}
