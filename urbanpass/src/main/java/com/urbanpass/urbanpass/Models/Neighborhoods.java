package com.urbanpass.urbanpass.Models;

import java.util.Set;
import jakarta.persistence.*;

@Entity
@Table(name = "neighborhoods")
public class Neighborhoods {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false, name = "neighborhoodId")
    private Long neighborhoodId;

    @Column(nullable = false)
    private String neighborhoodName;

    @ManyToMany(mappedBy = "neighborhoods")
    private Set<Routes> routes;

    // Getters and Setters
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

    public Set<Routes> getRoutes() {
        return routes;
    }

    public void setRoutes(Set<Routes> routes) {
        this.routes = routes;
    }
}
