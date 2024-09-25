package com.co.ke.Ritz.controllers;

import com.co.ke.Ritz.articles.models.Articles;
import com.co.ke.Ritz.articles.models.Authors;
import com.co.ke.Ritz.dto.ArticleDTO;
import com.co.ke.Ritz.dto.AuthorDTO;
import com.co.ke.Ritz.services.AuthorService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/authors")
public class AuthorController {
    @Autowired
    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    private final AuthorService authorService;

    @PostMapping("/add")
    public Authors addArticle(@RequestBody AuthorDTO authorDTO) {
        System.out.println(authorService.addAuthors(authorDTO));
        return authorService.addAuthors(authorDTO);
    }
    @GetMapping("/getAll")
    public List<Authors> getAuthors(Authors authors) {
        return authorService.getAll(authors);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        try {
            authorService.deleteAuthor(id);
            return ResponseEntity.noContent().build();
        } catch (EntityNotFoundException exception) {
            return ResponseEntity.notFound().build();
        }
    }

}
