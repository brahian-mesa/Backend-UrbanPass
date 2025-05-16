package com.urbanpass.urbanpass.Models;

import java.util.Set;
import jakarta.persistence.*;

@Entity
@Table(name = "buses")
public class Buses {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false, name = "busId")
    private Long busId;

    @OneToOne
    @JoinColumn(name = "fence_id")
    private Fences fence;

    @ManyToMany(mappedBy = "buses")
    private Set<Routes> routes;

    // Getters and Setters
    public Long getBusId() {
        return busId;
    }

    public void setBusId(Long busId) {
        this.busId = busId;
    }

    public Fences getFence() {
        return fence;
    }

    public void setFence(Fences fence) {
        this.fence = fence;
    }

    public Set<Routes> getRoutes() {
        return routes;
    }

    public void setRoutes(Set<Routes> routes) {
        this.routes = routes;
    }
}