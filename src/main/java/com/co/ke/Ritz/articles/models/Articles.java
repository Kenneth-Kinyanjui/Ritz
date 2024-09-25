package com.co.ke.Ritz.articles.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.*;

import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Articles {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "deleted_date")
    private LocalDateTime deletedDate;

    @Column(name = "description")
    private String description;

    @Column(name = "is_edited")
    private Boolean isEdited;

    @Column(name = "posted_date")
    private LocalDateTime postedDate;

    @Column(name = "title")
    private String title;

    @Column(name = "title_id")
    private String titleId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "author_id", nullable = true) // Foreign key column
    private Authors author;

}
