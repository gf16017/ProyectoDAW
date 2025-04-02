package com.example.application.services;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.application.Entities.Transactions;
import com.example.application.Entities.TransactionsRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class TransactionService {
    private final TransactionsRepository transactionsRepository;

    public TransactionService(TransactionsRepository transactionsRepository){
        this.transactionsRepository = transactionsRepository;
    }

    // Operaciones CRUD
    public List<Transactions> getAllTransactions() {
        return transactionsRepository.findAll();
    }
    
    public Optional<Transactions> getTransactionById(Long id) {
        return transactionsRepository.findById(id);
    }
    
    public Transactions saveTransaction(Transactions transaction) {
        return transactionsRepository.save(transaction);
    }
    
    public void deleteTransaction(Long id) {
        transactionsRepository.deleteById(id);
    }
    
    public Transactions updateTransaction(Long id, Transactions updatedTransaction) {
        return transactionsRepository.findById(id)
            .map(existingTransaction -> {
            // Actualiza solo los campos que necesitas
                existingTransaction.setTransactionAmount(updatedTransaction.getTransactionAmount());
                existingTransaction.setNotes(updatedTransaction.getNotes());
                existingTransaction.setCategory(updatedTransaction.getCategory());
                existingTransaction.setTransactionDate(updatedTransaction.getTransactionDate());
                existingTransaction.setTransactionName(updatedTransaction.getTransactionName());
            // Guarda la entidad actualizada
                return transactionsRepository.save(existingTransaction);
        })
            .orElseThrow(() -> new EntityNotFoundException("Transaction not found with id: " + id));
}
    
    // Métodos específicos para la gestión de gastos
    public List<Transactions> getTransactionsByCategory(String category) {
        return transactionsRepository.findByCategory(category);
    }
    
    public List<Transactions> getTransactionsBetweenDates(LocalDate startDate, LocalDate endDate) {
        return transactionsRepository.findByDateBetween(startDate, endDate);
    }
    
    public BigDecimal calculateTotalExpensesByMonth(int month, int year) {
        // Lógica para calcular gastos mensuales
        return transactionsRepository.sumAmountByMonthAndYear(month, year);
    }

    
}
