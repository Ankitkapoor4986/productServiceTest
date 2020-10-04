package com.ankit.product.model;

import lombok.Data;

import java.time.LocalDate;

@Data
public class Reviews {

    private LocalDate reviewDate;
    private String reviewer;
    private String review;


}
