package com.ll.rest1.article.article.controller;

import com.ll.rest1.article.article.entity.Article;
import com.ll.rest1.article.article.form.ArticleForm;
import com.ll.rest1.article.article.service.ArticleService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class ArticleController {

    private final ArticleService articleService;

    @GetMapping("/write")
    public String getWriteForm(Model model) {
        model.addAttribute("articleForm", new ArticleForm());
        return "write";
    }

    @PostMapping("/write")
    public String submitWriteForm(@Valid ArticleForm articleForm, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "write";
        }

        Article article = new Article();
        article.setSubject(articleForm.getSubject());
        article.setContent(articleForm.getContent());
        articleService.save(article);
        return "redirect:/";
    }

    @GetMapping("list")
    public String showList(Model model) {
        List<Article> articleList = articleService.findAll();
        model.addAttribute("articleList", articleList);
        return "show_list";
    }

    @GetMapping("/article/{id}")
    public String showArticleDetail(@PathVariable Long id, Model model) {
        Article article = articleService.findById(id).get();
        model.addAttribute("article", article);
        return "article_detail";
    }

    @DeleteMapping("/delete/{id}")
    public String deleteArticle(@PathVariable Long id) {
        articleService.delete(id);
        return "redirect:/list";
    }

    @GetMapping("/edit/{id}")
    public String showArticleBeforeEdit(@PathVariable Long id, Model model) {
        Article article = articleService.findById(id).get();
        ArticleForm articleForm = new ArticleForm();
        articleForm.setSubject(article.getSubject());
        articleForm.setContent(article.getContent());
        model.addAttribute("articleForm", articleForm);
        return "edit";
    }


    @PutMapping("/edit/{id}")
    public String editArticle(@PathVariable Long id, @Valid ArticleForm articleForm, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "edit";
        }
        Article article = articleService.findById(id).get();
        article.setSubject(articleForm.getSubject());
        article.setContent(articleForm.getContent());
        articleService.save(article);
        return "redirect:/list";
    }

    @GetMapping("/search")
    public String searchArticle(@RequestParam("text") String text, Model model) {
        List<Article> articleList = articleService.findBySubjectOrContent(text);
        model.addAttribute("articleList", articleList);
        return "/search";
    }
}
