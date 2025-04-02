package com.example.application.Entities;
import java.util.Date;
import java.util.List;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.persistence.GenerationType;
import jakarta.persistence.OneToMany;
import jakarta.persistence.CascadeType;

@Entity
@Table(name= "Account")
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "id_account")
    private Long idAccount;

    @Column(nullable = false, unique = true)
    private String accountName;

    @Column(nullable = false)
    private double total;

    @Column(nullable = false)
    private double initialBalance;

    @Column(nullable = false)
    private String accountType;

    @Column(nullable = false)
    private String currency;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false, updatable = false)
    private Date createdAt = new Date();

    @Column(nullable = false)
    private boolean isActive = true;
//JPA Relationships
    //Transactions
    @OneToMany(mappedBy = "account", cascade = CascadeType.ALL)
    private List<Transactions> transactions;

    //User
    @ManyToOne
    @JoinColumn (name = "user_id", nullable = false)
    private User user;
    
//Getter and Setters

public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

public List<Transactions> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<Transactions> transactions) {
        this.transactions = transactions;
    }

public Long getIdAccount() {
    return idAccount;
}

public void setIdAccount(Long idAccount) {
    this.idAccount = idAccount;
}

public String getAccountName() {
    return accountName;
}

public void setAccountName(String accountName) {
    this.accountName = accountName;
}

public double getTotal() {
    return total;
}

public void setTotal(double total) {
    this.total = total;
}

public double getInitialBalance() {
    return initialBalance;
}

public void setInitialBalance(double initialBalance) {
    this.initialBalance = initialBalance;
}

public String getAccountType() {
    return accountType;
}

public void setAccountType(String accountType) {
    this.accountType = accountType;
}

public String getCurrency() {
    return currency;
}

public void setCurrency(String currency) {
    this.currency = currency;
}

public Date getCreatedAt() {
    return createdAt;
}

public void setCreatedAt(Date createdAt) {
    this.createdAt = createdAt;
}

public boolean isActive() {
    return isActive;
}

public void setActive(boolean isActive) {
    this.isActive = isActive;
}

}
