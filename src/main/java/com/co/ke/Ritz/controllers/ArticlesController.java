package com.co.ke.Ritz.controllers;

import com.co.ke.Ritz.articles.models.Articles;
import com.co.ke.Ritz.dto.ArticleDTO;
import com.co.ke.Ritz.services.ArticlesService;
import jakarta.persistence.Id;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/articles")
public class ArticlesController {
    private final ArticlesService articlesService;

    // Constructor-based dependency injection
    @Autowired
    public ArticlesController(ArticlesService articlesService) {
        this.articlesService = articlesService;
    }

    @PostMapping("/add")
    public Articles addArticle(@RequestBody ArticleDTO articleDTO) {
        System.out.println(articlesService.addArticle(articleDTO));
        return articlesService.addArticle(articleDTO);
    }

    @GetMapping("/getAll")
    public List<Articles> getAll() {

        return articlesService.getAllArticle();
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteArticle (@PathVariable Long id) {
        articlesService.deleteArticle(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Articles> updateArticle(@PathVariable Long id, @RequestBody ArticleDTO articleDTO) {
        Articles updatedArticle = articlesService.editArticle(id, articleDTO);
        return ResponseEntity.ok(updatedArticle);
    }



}
