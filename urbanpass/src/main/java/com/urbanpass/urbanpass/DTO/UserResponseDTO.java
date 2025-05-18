package com.urbanpass.urbanpass.DTO;

import java.util.List;
import java.util.stream.Collectors;
import com.urbanpass.urbanpass.Models.Users;
import com.urbanpass.urbanpass.Models.Cards;

public class UserResponseDTO {
    private Long userId;
    private String userName;
    private String userEmail;
    private String userAddress;
    private String userNumber;
    private List<CardDTO> cards;

    public static UserResponseDTO fromUser(Users user) {
        UserResponseDTO dto = new UserResponseDTO();
        dto.setUserId(user.getUserId());
        dto.setUserName(user.getUserName());
        dto.setUserEmail(user.getUserEmail());
        dto.setUserAddress(user.getUserAddress());
        dto.setUserNumber(user.getUserNumber());
        if (user.getCards() != null) {
            dto.setCards(user.getCards().stream()
                    .map(CardDTO::fromCard)
                    .collect(Collectors.toList()));
        }
        return dto;
    }

    // Getters and setters
    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserAddress() {
        return userAddress;
    }

    public void setUserAddress(String userAddress) {
        this.userAddress = userAddress;
    }

    public String getUserNumber() {
        return userNumber;
    }

    public void setUserNumber(String userNumber) {
        this.userNumber = userNumber;
    }

    public List<CardDTO> getCards() {
        return cards;
    }

    public void setCards(List<CardDTO> cards) {
        this.cards = cards;
    }

    // Inner static class for Card DTO
    public static class CardDTO {
        private Long cardId;
        private double cardBalance;
        private String cardNumber;
        private int cardCvc;

        public static CardDTO fromCard(Cards card) {
            CardDTO dto = new CardDTO();
            dto.setCardId(card.getCardId());
            dto.setCardBalance(card.getCardBalance());
            dto.setCardNumber(card.getCardNumber());
            dto.setCardCvc(card.getCardCvc());
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
    }
}