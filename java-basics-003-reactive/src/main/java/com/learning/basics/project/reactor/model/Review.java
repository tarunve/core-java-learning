package com.learning.basics.project.reactor.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Review {
    private Long reviewId;
    private Long movieInfoId;
    private String comment;
    private Double rating;
}