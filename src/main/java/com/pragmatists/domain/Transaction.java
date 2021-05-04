package com.pragmatists.domain;

import java.time.LocalDate;
import java.util.Objects;

public class Transaction {

    private final LocalDate date;
    private final Amount amount;

    public Transaction(LocalDate date, Amount amount) {
        this.date = date;
        this.amount = amount;
    }

    public Amount amount() {
        return amount;
    }

    public LocalDate date() {
        return date;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "date='" + date +
                ", amount=" + amount + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Transaction that = (Transaction) o;
        return Objects.equals(date, that.date) && Objects.equals(amount, that.amount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(date, amount);
    }
}
