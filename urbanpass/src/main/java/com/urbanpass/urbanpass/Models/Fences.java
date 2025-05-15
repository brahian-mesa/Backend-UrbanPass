package com.urbanpass.urbanpass.Models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "fences")
public class Fences {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false, name = "fenceId")
    private Long fenceId;

    @Column(nullable = false, unique = true)
    private String fenceCode;

    public Long getFenceId() {
        return fenceId;
    }
    public void setFenceId(Long fenceId) {
        this.fenceId = fenceId;
    }

    public String getFenceCode() {
        return fenceCode;
    }

    public void setFenceCode(String fenceCode) {
        this.fenceCode = fenceCode;
    }
}
