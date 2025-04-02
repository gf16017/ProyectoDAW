package com.example.application.Entities;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface TransactionsRepository
    extends
        JpaRepository<Transactions, Long>,
        JpaSpecificationExecutor<Transactions>{

    List<Transactions> findByCategory (String category);
    List<Transactions> findByDateBetween(LocalDate starDate, LocalDate endDate);

    @Query("SELECT SUM(t.amount) FROM Transaction t WHERE MONTH(t.date) = :month AND YEAR(t.date) = :year")
    BigDecimal sumAmountByMonthAndYear(@Param("month") int month, @Param("year") int year);

    @Query("SELECT t.category, SUM(t.amount) FROM Transaction t GROUP BY t.category")
    List<Object[]> sumAmountGroupByCategory();
    
}
