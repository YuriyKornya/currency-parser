package com.petproject.parsing.service;

import com.petproject.parsing.dto.CurrencyDto;
import com.petproject.parsing.entity.Currency;
import com.petproject.parsing.repository.CurrencyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CurrencyService {
     private final RestClient restClient;
     private final CurrencyRepository currencyRepository;

     public List<CurrencyDto> getCurrency() {
          List<CurrencyDto> result = restClient.get()
                  .uri("https://bank.gov.ua/NBUStatService/v1/statdirectory/exchange?json")
                  .retrieve()
                  .body(new ParameterizedTypeReference<List<CurrencyDto>>() {
                  });
          return result;
     }

     @Scheduled(cron = "0 0 9 * * *")
     public void saveCurrencies() {
          List<CurrencyDto> dtos = getCurrency(); // шаг 1

          List<Currency> currencies = new ArrayList<>(); // пустой список

          for (CurrencyDto dto : dtos) { // шаг 2 - идём по каждому DTO
               Currency currency = new Currency();
               currency.setR030(dto.getR030());
               currency.setCc(dto.getCc());
               currency.setTxt(dto.getTxt());
               currency.setRate(dto.getRate());
               currency.setExchangeDate(dto.getExchangeDate());

               currencies.add(currency); // добавляем в список
          }
          if (!currencyRepository.existsByExchangeDate(LocalDate.now())) {
               currencyRepository.saveAll(currencies);
          }
     }
}
