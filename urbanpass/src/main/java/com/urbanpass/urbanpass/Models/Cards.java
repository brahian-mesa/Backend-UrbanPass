package com.urbanpass.urbanpass.Models;

import java.sql.Date;
import java.util.Set;
import jakarta.persistence.*;

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

    @ManyToOne
    @JoinColumn(name = "userId")
    private Users user;

    @OneToMany(mappedBy = "card")
    private Set<Records> records;

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

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }

    public Set<Records> getRecords() {
        return records;
    }

    public void setRecords(Set<Records> records) {
        this.records = records;
    }
}
