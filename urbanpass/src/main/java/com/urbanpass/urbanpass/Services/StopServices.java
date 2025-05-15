package com.urbanpass.urbanpass.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import com.urbanpass.urbanpass.Models.Stops;
import com.urbanpass.urbanpass.Repository.StopsRepository;

@Service
public class StopServices {

    @Autowired
    StopsRepository stopRepositorios;

    public ArrayList<Stops> obtenerStops() {
        return (ArrayList<Stops>) stopRepositorios.findAll();
    }

    public Stops guardarStops(Stops stops) {
        return stopRepositorios.save(stops);
    }

    public Stops obtenerPorId(Long id) {
        return stopRepositorios.findById(id).orElse(null);
    }

    public ArrayList<Stops> obtenerPorNombre(String stopName) {
        return stopRepositorios.findByStopName(stopName);
    }

    // ❌ Este estaba mal
    // public ArrayList<Stops> obtenerPorId(String stopId)

    // ✅ Si necesitas un método alternativo por ID
    public Stops obtenerPorCodigo(Long stopId) {
        return stopRepositorios.findByStopId(stopId);
    }

    public boolean eliminarStop(Long id) {
        try {
            stopRepositorios.deleteById(id);
            return true;
        } catch (Exception err) {
            return false;
        }
    }
}
