package com.ll.rest1.article.comment.controller;

import com.ll.rest1.article.comment.entity.Comment;
import com.ll.rest1.article.comment.form.CommentForm;
import com.ll.rest1.article.comment.service.CommentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RequiredArgsConstructor
@Controller
public class CommentController {

    private final CommentService commentService;

    @PostMapping("/article/{id}")
    public String writeComment(@PathVariable Long id, @Valid CommentForm commentForm, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "redirect:/article/" + id;
        }
        Comment comment = new Comment();
        comment.setContent(commentForm.getContent());
        commentService.addComment(id, comment);
        return "redirect:/article/" + id;

    }
}
