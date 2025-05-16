package com.urbanpass.urbanpass.Models;

import java.util.Set;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.OneToOne;
import jakarta.persistence.OneToMany;

@Entity
@Table(name = "fences")
public class Fences {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false, name = "fenceId")
    private Long fenceId;

    @OneToOne(mappedBy = "fence")
    private Buses bus;

    @OneToMany(mappedBy = "fence")
    private Set<Records> records;

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

    public Buses getBus() {
        return bus;
    }

    public void setBus(Buses bus) {
        this.bus = bus;
    }

    public Set<Records> getRecords() {
        return records;
    }

    public void setRecords(Set<Records> records) {
        this.records = records;
    }
}
