package com.example.application.Entities;
import java.util.List;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Table;
import jakarta.persistence.GenerationType;
import jakarta.persistence.OneToMany;
import jakarta.persistence.CascadeType;

@Entity
@Table(name= "Category")
public class Category {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_category")
    private Long idCategory;

    @Column(nullable = false)
    private String categoryName;

    @Column(nullable = false)
    private CategoryType type;
//JPA Relationship
    //User
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    //Transactions
    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL)
    private List<Transactions> transactions;

    //Budget
    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL)
    private List<Budget> budgets;

//Getter and Setters

public List<Budget> getBudgets() {
        return budgets;
    }

    public void setBudgets(List<Budget> budgets) {
        this.budgets = budgets;
    }

public List<Transactions> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<Transactions> transactions) {
        this.transactions = transactions;
    }

public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public CategoryType getType() {
        return type;
    }

    public void setType(CategoryType type) {
        this.type = type;
    }

    @Column(nullable = false)
    private boolean isActive = true;

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean isActive) {
        this.isActive = isActive;
    }


    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public Long getIdCategory() {
        return idCategory;
    }

    public void setIdCategoryt(Long idCategory) {
        this.idCategory = idCategory;
    }

public enum CategoryType{
    INCOME,
    EXPENSE,
    SAVINGS,
    INVESTMENT
}

}
