package com.ankit.product.model;

import com.ankit.product.util.LocalDateDeserializer;
import com.ankit.product.util.LocalDateSerializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Data;

import java.time.LocalDate;

@Data
public class Reviews {

    @JsonSerialize(using = LocalDateSerializer.class)
    @JsonDeserialize(using = LocalDateDeserializer.class)
    private LocalDate reviewDate;
    private String reviewer;
    private String review;


}
