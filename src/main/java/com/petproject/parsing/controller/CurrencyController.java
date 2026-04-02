package com.petproject.parsing.controller;

import com.petproject.parsing.dto.CurrencyDto;
import com.petproject.parsing.service.CurrencyService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/currencies")
@RequiredArgsConstructor
public class CurrencyController {
    private final CurrencyService currencyService;

    @GetMapping
    public List <CurrencyDto> getCurrency () {
        return currencyService.getCurrency();
    }

    @PostMapping("/save")
    public void saveCurrency () {
        currencyService.saveCurrencies();
    }

}
