package com.urbanpass.urbanpass.Models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity 
@Table(name = "buses")
public class Buses {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false, name = "busId")
    private Long busId;
    
    private Long fencesId;

    public Long getBusId() {
        return busId;
    }
    public void setBusId(Long busId) {
        this.busId = busId;
    }
    public Long getFencesId() {
        return fencesId;
    }
    public void setFencesId(Long fencesId) {
        this.fencesId = fencesId;
    }
}
