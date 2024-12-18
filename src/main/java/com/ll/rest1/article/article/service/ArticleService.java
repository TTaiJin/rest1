package com.ll.rest1.article.article.service;

import com.ll.rest1.article.article.entity.Article;
import com.ll.rest1.article.article.repository.ArticleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class ArticleService {

    private final ArticleRepository articleRepository;

    public void save(Article article) {
        articleRepository.save(article);
    }

    public List<Article> findAll() {
        return articleRepository.findAll();
    }

    public Optional<Article> findById(Long id) {
        return articleRepository.findById(id);
    }

    public void delete(Long id) {
        Article article = articleRepository.findById(id).get();
        articleRepository.delete(article);
    }

    public List<Article> findBySubjectOrContent(String text) {
        return articleRepository.findBySubjectContainingOrContentContaining(text, text);
    }
}
