package com.urbanpass.urbanpass.Repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.urbanpass.urbanpass.Models.Buses;

@Repository
public interface BusesRepository extends CrudRepository<Buses, Long> {

    // Buscar buses por busId
    public abstract List<Buses> findByBusId(Long busId);

    // Buscar buses por fencesId (ajustado para coincidir con el campo de la clase)
    public abstract List<Buses> findByFencesId(Long fencesId);
}
