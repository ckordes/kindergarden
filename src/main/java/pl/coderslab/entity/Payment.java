package pl.coderslab.entity;

import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
public class Payment {
    @Id
    @GeneratedValue
    private long id;

    @NotBlank
    private int month;
    @NotBlank
    private int year;
    @NotBlank
    private double amount;
    @NotNull
    @ManyToOne//(fetch = FetchType.EAGER)
    private Child child;

    public Payment() {
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Child getChild() {
        return child;
    }

    public void setChild(Child child) {
        this.child = child;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
}


/*
Payment:
Miesiac
Saldo
Dziecko
 */