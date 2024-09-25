package com.co.ke.Ritz.repository;

import com.co.ke.Ritz.articles.models.Authors;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepo extends JpaRepository<Authors, Long> {

}
