package com.urbanpass.urbanpass.Controls;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.urbanpass.urbanpass.Models.Neighborhoods;
import com.urbanpass.urbanpass.Services.NeighborhoodsService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;

@RestController
@RequestMapping("api/neighborhoods")
public class NeighborhoodsControl {

    @Autowired
    NeighborhoodsService neighborhoodsService;

    @GetMapping()
    public ArrayList<Neighborhoods> obtenerNeighborhoods() {
        return neighborhoodsService.obtenerNeighborhoods();
    }

    @PostMapping()
    public Neighborhoods guardarNeighborhoods(@RequestBody Neighborhoods neighborhoods) {
        return neighborhoodsService.guardarNeighborhoods(neighborhoods);
    }

    @GetMapping(path = "/id/{id}")
    public Neighborhoods obtenerNeighborhoodPorId(@PathVariable("id") Long id) {
        return neighborhoodsService.obtenerPorId(id);
    }

    @GetMapping(path = "/name")
    public ArrayList<Neighborhoods> obtenerNeighborhoodPorNombre(@RequestParam("neighborhoodsName") String neighborhoodsName) {
        return neighborhoodsService.obtenerPorNameNeighborhoods(neighborhoodsName);
    }

    @GetMapping(path = "/idNeighborhoods")
    public ArrayList<Neighborhoods> obtenerNeighborhoodPorIdNeighborhoods(@RequestParam("idNeighborhoods") Long idNeighborhoods) {
        return neighborhoodsService.obtenerPorIdNeighborhoods(idNeighborhoods);
    }

    @DeleteMapping(path = "/{id}")
    public boolean eliminarNeighborhoods(@PathVariable("id") Long id) {
        return neighborhoodsService.eliminarNeighborhoods(id);
    }
}
