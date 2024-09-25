package com.co.ke.Ritz.repository;

import com.co.ke.Ritz.articles.models.Articles;
import jakarta.persistence.Id;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.lang.annotation.Native;
import java.util.List;
import java.util.Optional;

@Repository
public interface ArticleRepo extends JpaRepository<Articles, Long> {




//    @Query(value = "SELECT * FROM `article` WHERE `titleId`=:title", nativeQuery = true)
//    Optional<Ar> findByAccountId(String acid);

}
