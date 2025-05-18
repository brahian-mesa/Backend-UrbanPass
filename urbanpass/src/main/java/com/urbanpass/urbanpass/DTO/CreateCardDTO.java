package com.urbanpass.urbanpass.DTO;

import java.sql.Date;

public class CreateCardDTO {
    private double cardBalance;
    private String cardNumber;
    private int cardCvc;
    private Date cardExpedition;
    private Long userId;

    // Getters and setters
    public double getCardBalance() {
        return cardBalance;
    }

    public void setCardBalance(double cardBalance) {
        this.cardBalance = cardBalance;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public int getCardCvc() {
        return cardCvc;
    }

    public void setCardCvc(int cardCvc) {
        this.cardCvc = cardCvc;
    }

    public Date getCardExpedition() {
        return cardExpedition;
    }

    public void setCardExpedition(Date cardExpedition) {
        this.cardExpedition = cardExpedition;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}