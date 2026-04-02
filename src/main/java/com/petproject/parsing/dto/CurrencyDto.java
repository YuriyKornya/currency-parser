package com.petproject.parsing.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.time.LocalDate;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class CurrencyDto {
    private Long r030;
    private String cc;
    private String txt;
    private Double rate;
    @JsonFormat(pattern = "dd.MM.yyyy")
    @JsonProperty("exchangedate")
    private LocalDate exchangeDate;

}
