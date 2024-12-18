package com.ll.rest1.article.article.repository;

import com.ll.rest1.article.article.entity.Article;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ArticleRepository extends JpaRepository<Article, Long> {
    List<Article> findBySubjectContainingOrContentContaining(String subject, String content);
}
