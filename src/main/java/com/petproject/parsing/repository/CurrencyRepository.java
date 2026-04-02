package com.petproject.parsing.repository;

import com.petproject.parsing.entity.Currency;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;

public interface CurrencyRepository extends JpaRepository <Currency, Long> {
    boolean existsByExchangeDate(LocalDate exchangeDate);
}
