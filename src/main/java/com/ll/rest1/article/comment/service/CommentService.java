package com.ll.rest1.article.comment.service;

import com.ll.rest1.article.article.entity.Article;
import com.ll.rest1.article.article.repository.ArticleRepository;
import com.ll.rest1.article.comment.entity.Comment;
import com.ll.rest1.article.comment.repository.CommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class CommentService {

    private final CommentRepository commentRepository;
    private final ArticleRepository articleRepository;


    @Transactional
    public void addComment(Long id, Comment comment) {
        Article article = articleRepository.findById(id).get();
        commentRepository.save(comment);

        article.addComment(comment);
    }
}
