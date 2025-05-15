package com.urbanpass.urbanpass.Services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.urbanpass.urbanpass.Models.Buses;
import com.urbanpass.urbanpass.Repository.BusesRepository;

@Service
public class BusesService {

    @Autowired
    BusesRepository busesRepository;

    // Obtener buses por busId
    public List<Buses> getBusesByBusId(Long busId) {
        return busesRepository.findByBusId(busId);
    }

    // Obtener buses por fencesId
    public List<Buses> getBusesByFencesId(Long fencesId) {
        return busesRepository.findByFencesId(fencesId);
    }

    // Obtener todos los buses
    public Iterable<Buses> getAllBuses() {
        return busesRepository.findAll();
    }

    // Guardar un nuevo bus
    public Buses saveBus(Buses bus) {
        return busesRepository.save(bus);
    }

    // Eliminar un bus por busId
    public void deleteBus(Long busId) {
        busesRepository.deleteById(busId);
    }
}
