package com.ll.rest1.article.article.form;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import java.time.LocalDateTime;

@Setter
@Getter
public class ArticleForm {

    @NotBlank(message = "공백은 안됩니다.")
    @Length(min = 2, message = "2글자 이상 입력해주세요.")
    private String subject;

    @NotBlank(message = "공백은 안됩니다.")
    @Length(min = 2, message = "2글자 이상 입력해주세요.")
    private String content;

    private LocalDateTime createDate;

    private LocalDateTime lastModifiedDate;
}
