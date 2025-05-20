//Registro
package com.urbanpass.urbanpass.Models;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;

@Entity
@Table(name = "records")
public class Records {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false, name = "recordId")
    private long recordId;

    private Date recordDate;

    @Column(nullable = false)
    private String operationType; // "RECHARGE" o "FENCE_USE"

    @Column(nullable = false)
    private double amount; // Monto de la recarga o uso

    @ManyToOne
    @JoinColumn(name = "cardId")
    private Cards card;

    @ManyToOne
    @JoinColumn(name = "fenceId")
    private Fences fence;

    public long getRecordId() {
        return recordId;
    }

    public void setRecordId(long recordId) {
        this.recordId = recordId;
    }

    public Date getRecordDate() {
        return recordDate;
    }

    public void setRecordDate(Date recordDate) {
        this.recordDate = recordDate;
    }

    public String getOperationType() {
        return operationType;
    }

    public void setOperationType(String operationType) {
        this.operationType = operationType;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Cards getCard() {
        return card;
    }

    public void setCard(Cards card) {
        this.card = card;
    }

    public Fences getFence() {
        return fence;
    }

    public void setFence(Fences fence) {
        this.fence = fence;
    }
}
