package com.urbanpass.urbanpass.Models;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "cards")
public class Cards {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false, name = "cardId")
    private Long cardId;
    private double cardBalance;
    private int cardCvc;
    private Date cardExpedition;

    public Long getCardId() {
        return cardId;
    }
    public void setCardId(Long cardId) {
        this.cardId = cardId;
    }
    public double getCardBalance() {
        return cardBalance;
    }
    public void setCardBalance(double cardBalance) {
        this.cardBalance = cardBalance;
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
    
}
