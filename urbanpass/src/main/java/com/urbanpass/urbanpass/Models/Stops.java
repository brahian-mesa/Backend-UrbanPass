package com.urbanpass.urbanpass.Models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "stops")
public class Stops {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false, name = "stopId")
    
    private Long stopId;
    private String stopName;
    private Double stopLong;
    private Double stopLat;

    public Long getStopId() {
        return stopId;
    }
    public void setStopId(Long stopId) {
        this.stopId = stopId;
    }

      public String getStopName() {
        return stopName;
    }
    public void setStopName(String stopName) {
        this.stopName = stopName;
    }
    
    public Double getStopLong() {
        return stopLong;
    }
    public void setStopLong(Double stopLong) {
        this.stopLong = stopLong;
    }
    public Double getStopLat() {
        return stopLat;
    }
    public void setStopLat(Double stopLat) {
        this.stopLat = stopLat;
    } 
}
