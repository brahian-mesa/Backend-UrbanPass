package com.urbanpass.urbanpass.DTO;

import java.sql.Date;
import com.urbanpass.urbanpass.Models.Cards;

public class CardResponseDTO {
    private Long cardId;
    private double cardBalance;
    private String cardNumber;
    private int cardCvc;
    private Date cardExpedition;
    private Long userId;

    public static CardResponseDTO fromCard(Cards card) {
        CardResponseDTO dto = new CardResponseDTO();
        dto.setCardId(card.getCardId());
        dto.setCardBalance(card.getCardBalance());
        dto.setCardNumber(card.getCardNumber());
        dto.setCardCvc(card.getCardCvc());
        dto.setCardExpedition(card.getCardExpedition());
        if (card.getUser() != null) {
            dto.setUserId(card.getUser().getUserId());
        }
        return dto;
    }

    // Getters and setters
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