package com.urbanpass.urbanpass.Controls;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.urbanpass.urbanpass.Models.Buses;
import com.urbanpass.urbanpass.Services.BusesService;

@RestController
@RequestMapping("api/buses")
public class BusesControl {

    @Autowired
    BusesService busesService;

    // Endpoint para obtener todos los buses
    @GetMapping()
    public Iterable<Buses> obtenerBuses() {
        return busesService.getAllBuses();
    }

    // Endpoint para obtener buses por su ID
    @GetMapping(path = "/id/{busId}")
    public ResponseEntity<List<Buses>> obtenerBusesPorId(@PathVariable("busId") Long busId) {
        List<Buses> buses = busesService.getBusesByBusId(busId);
        if (buses.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND); // Retornar 404 si no se encuentran buses
        }
        return new ResponseEntity<>(buses, HttpStatus.OK);
    }

    // Endpoint para obtener buses por fencesId
    @GetMapping(path = "/fence/{fencesId}")
    public ResponseEntity<List<Buses>> obtenerBusesPorFence(@PathVariable("fencesId") Long fencesId) {
        List<Buses> buses = busesService.getBusesByFencesId(fencesId);
        if (buses.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND); // Retornar 404 si no se encuentran buses
        }
        return new ResponseEntity<>(buses, HttpStatus.OK);
    }

    // Endpoint para guardar un nuevo bus
    @PostMapping()
    public ResponseEntity<Buses> guardarBus(@RequestBody Buses bus) {
        Buses savedBus = busesService.saveBus(bus);
        return new ResponseEntity<>(savedBus, HttpStatus.CREATED); // Retornar 201 si el bus fue creado exitosamente
    }

    // Endpoint para eliminar un bus
    @DeleteMapping(path = "/delete/{busId}")
    public ResponseEntity<Void> eliminarBus(@PathVariable("busId") Long busId) {
        if (!busesService.getBusesByBusId(busId).isEmpty()) {
            busesService.deleteBus(busId);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT); // Retornar 204 si se eliminó el bus
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND); // Retornar 404 si el bus no se encontró
    }
}
