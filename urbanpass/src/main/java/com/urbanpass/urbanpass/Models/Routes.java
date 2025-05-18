package com.urbanpass.urbanpass.Models;

import java.util.List;
import java.util.Set;
import jakarta.persistence.*;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "routes")
public class Routes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false, name = "routeId")
    private Long routeId;

    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false)
    private String origen;

    @Column(nullable = false)
    private String destino;

    @ElementCollection
    private List<String> waypoints;

    @JsonProperty("horario_lunes_a_sabado")
    @Column(name = "horario_lunes_a_sabado")
    private String horarioLunesASabado;

    @JsonProperty("horario_domingo_festivo")
    @Column(name = "horario_domingo_festivo")
    private String horarioDomingoFestivo;

    @ManyToMany
    @JoinTable(name = "route_bus", joinColumns = @JoinColumn(name = "route_id"), inverseJoinColumns = @JoinColumn(name = "bus_id"))
    private Set<Buses> buses;

    @ManyToMany
    @JoinTable(name = "route_neighborhood", joinColumns = @JoinColumn(name = "route_id"), inverseJoinColumns = @JoinColumn(name = "neighborhood_id"))
    private Set<Neighborhoods> neighborhoods;

    @ManyToMany
    @JoinTable(name = "route_stop", joinColumns = @JoinColumn(name = "route_id"), inverseJoinColumns = @JoinColumn(name = "stop_id"))
    private Set<Stops> stops;

    // Getters and Setters
    public Long getRouteId() {
        return routeId;
    }

    public void setRouteId(Long routeId) {
        this.routeId = routeId;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getOrigen() {
        return origen;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public List<String> getWaypoints() {
        return waypoints;
    }

    public void setWaypoints(List<String> waypoints) {
        this.waypoints = waypoints;
    }

    @JsonProperty("horario_lunes_a_sabado")
    public String getHorarioLunesASabado() {
        return horarioLunesASabado;
    }

    @JsonProperty("horario_lunes_a_sabado")
    public void setHorarioLunesASabado(String horarioLunesASabado) {
        this.horarioLunesASabado = horarioLunesASabado;
    }

    @JsonProperty("horario_domingo_festivo")
    public String getHorarioDomingoFestivo() {
        return horarioDomingoFestivo;
    }

    @JsonProperty("horario_domingo_festivo")
    public void setHorarioDomingoFestivo(String horarioDomingoFestivo) {
        this.horarioDomingoFestivo = horarioDomingoFestivo;
    }

    public Set<Buses> getBuses() {
        return buses;
    }

    public void setBuses(Set<Buses> buses) {
        this.buses = buses;
    }

    public Set<Neighborhoods> getNeighborhoods() {
        return neighborhoods;
    }

    public void setNeighborhoods(Set<Neighborhoods> neighborhoods) {
        this.neighborhoods = neighborhoods;
    }

    public Set<Stops> getStops() {
        return stops;
    }

    public void setStops(Set<Stops> stops) {
        this.stops = stops;
    }
}