package com.co.ke.Ritz.services;

import com.co.ke.Ritz.articles.models.Authors;
import com.co.ke.Ritz.dto.AuthorDTO;
import com.co.ke.Ritz.repository.AuthorRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class AuthorService {
    @Autowired
    public AuthorService(AuthorRepo authorRepo) {
        this.authorRepo = authorRepo;
    }



    private final AuthorRepo authorRepo;


    public Authors addAuthors(@RequestBody AuthorDTO authorDTO) {
        Authors author = new Authors();

        author.setAuthorFName(authorDTO.getAuthorFName());
        author.setAuthorLName(authorDTO.getAuthorLName());
        author.setAuthorId(authorDTO.getAuthorId());
        author.setPhone(authorDTO.getPhone());
        author.setEmail(authorDTO.getEmail());

        return authorRepo.save(author);
    }
    public List<Authors> getAll(Authors authors) {
        return authorRepo.findAll();
    }
    public ResponseEntity<Void> deleteAuthor(Long id) {
        authorRepo.deleteById(id);
        return ResponseEntity.noContent().build();
    }


}
