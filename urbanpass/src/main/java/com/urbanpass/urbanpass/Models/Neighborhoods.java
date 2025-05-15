package com.urbanpass.urbanpass.Models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name ="neighborhoods")
public class Neighborhoods {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false, name = "neighborhoodId")
    
    private Long neighborhoodId;
    private String neighborhoodName;

    public Long getNeighborhoodId() {
        return neighborhoodId;
    }
    public void setNeighborhoodId(Long neighborhoodId) {
        this.neighborhoodId = neighborhoodId;
    }
    public String getNeighborhoodName() {
        return neighborhoodName;
    }
    public void setNeighborhoodName(String neighborhoodName) {
        this.neighborhoodName = neighborhoodName;
    } 
}
