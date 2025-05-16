package com.urbanpass.urbanpass.Models;

import java.util.Date;
import jakarta.persistence.*;

@Entity
@Table(name = "bills")
public class Bills {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false, name = "billId")
    private Long billId;

    @Column(nullable = false)
    private Double amount;

    @Column(nullable = false)
    private Date billDate;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private Users user;

    // Getters and Setters
    public Long getBillId() {
        return billId;
    }

    public void setBillId(Long billId) {
        this.billId = billId;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Date getBillDate() {
        return billDate;
    }

    public void setBillDate(Date billDate) {
        this.billDate = billDate;
    }

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }
}
