package com.co.ke.Ritz.services;

import com.co.ke.Ritz.articles.models.Articles;
import com.co.ke.Ritz.dto.ArticleDTO;
import com.co.ke.Ritz.repository.ArticleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.time.LocalDateTime;
import java.util.List;
import java.util.ResourceBundle;

@Service
public class ArticlesService {
    private final ArticleRepo articleRepo;

    // Constructor-based injection
    @Autowired
    public ArticlesService(ArticleRepo articleRepo) {
        this.articleRepo = articleRepo;
    }
    private Articles articles;

    public Articles addArticle(@RequestBody ArticleDTO articleDTO) {
        Articles article = new Articles();
//        article.setAuthorId(articleDTO.getAuthorId());
        article.setDeletedDate(articleDTO.getDeletedDate());
        article.setDescription(articleDTO.getDescription());
        article.setIsEdited(false);
        article.setPostedDate(LocalDateTime.now());
        article.setTitle(articleDTO.getTitle());
        article.setTitleId(articleDTO.getTitleId());

        return articleRepo.save(article);
    }

    public List<Articles> getAllArticle() {
        return articleRepo.findAll();
    }

    public Articles editArticle(Long id, ArticleDTO articleDTO){
        Articles existingArticle = articleRepo.findById(id).orElseThrow();
        existingArticle.setTitle(articleDTO.getTitle());
        existingArticle.setDescription(articleDTO.getDescription());
        existingArticle.setIsEdited(true); // Mark as edited
        existingArticle.setPostedDate(articleDTO.getPostedDate());
        existingArticle.setDeletedDate(articleDTO.getDeletedDate());

        return articleRepo.save(existingArticle);
    }

    public ResponseEntity<Void> deleteArticle(Long id) {
        articleRepo.deleteById(id);
        return ResponseEntity.noContent().build();
    }


}
