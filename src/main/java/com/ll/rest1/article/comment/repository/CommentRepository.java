package com.ll.rest1.article.comment.repository;

import com.ll.rest1.article.comment.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Long> {
}
