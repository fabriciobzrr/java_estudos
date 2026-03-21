package model.entities;

import model.exceptions.BusinessException;

public class Account {
    private Integer number;
    private String holder;
    private Double balance;
    private Double withdrawLimit;

    public Account() {
    }

    public Account(Integer number, String holder, Double balance, Double withdrawLimit) {
        this.number = number;
        this.holder = holder;
        this.balance = balance;
        this.withdrawLimit = withdrawLimit;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getHolder() {
        return holder;
    }

    public void setHolder(String holder) {
        this.holder = holder;
    }

    public Double getBalance() {
        return balance;
    }

    public Double getWithdrawLimit() {
        return withdrawLimit;
    }

    public void deposit(Double amount) {
        this.balance += amount;
    }

    public void withdraw(Double withdrawValue) {
        validateWithDraw(withdrawValue);
        this.balance -= withdrawValue;
    }

    private void validateWithDraw(Double withdrawValue) {
        if (withdrawValue > withdrawLimit) {
            throw new BusinessException("a quantia excede o limite de saque diário.");
        }
        if (withdrawValue > balance) {
            throw new BusinessException("saldo insuficiente para esta operação.");
        }
    }
}
