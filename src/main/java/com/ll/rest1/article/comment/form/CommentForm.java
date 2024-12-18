package com.ll.rest1.article.comment.form;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import java.time.LocalDateTime;

@Getter
@Setter
public class CommentForm {

    @NotBlank(message = "공백은 안됩니다.")
    @Length(min = 2, message = "2글자 이상 입력해주세요.")
    private String content;

    private LocalDateTime createDate;

    private LocalDateTime lastModifiedDate;
}
