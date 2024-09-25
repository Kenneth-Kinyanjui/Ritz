package com.co.ke.Ritz.dto;

import lombok.Data;

import java.time.LocalDateTime;
@Data
public class ArticleDTO {
    private LocalDateTime deletedDate;
    private String description;
    private Boolean isEdited;
    private LocalDateTime postedDate;
    private String title;
    private String titleId;
}
