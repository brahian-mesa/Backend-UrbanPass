package com.urbanpass.urbanpass.Controls;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.urbanpass.urbanpass.Models.Stops;
import com.urbanpass.urbanpass.Services.StopServices;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("api/stops")
public class StopsControl {

    @Autowired
    StopServices stopServicios;

    @GetMapping
    public ArrayList<Stops> obtenerStops() {
        return stopServicios.obtenerStops();
    }

    @PostMapping()
    public Stops guardarStops(@RequestBody Stops stops) {
        return stopServicios.guardarStops(stops);
    }

    @GetMapping(path = "/id/{id}")
    public Stops obtenerStopPorId(@PathVariable("id") Long id) {
        return stopServicios.obtenerPorId(id);
    }

    @GetMapping(path = "/name")
    public ArrayList<Stops> obtenerStopPorNombre(@RequestParam("stopName") String stopName) {
        return stopServicios.obtenerPorNombre(stopName);
    }

    @GetMapping(path = "/code")
    public Stops obtenerStopPorCodigo(@RequestParam("stopId") Long stopId) {
        return stopServicios.obtenerPorCodigo(stopId);
    }
}
