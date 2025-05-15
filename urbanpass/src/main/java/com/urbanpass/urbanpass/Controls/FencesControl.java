package com.urbanpass.urbanpass.Controls;

import java.util.List;  // Cambié ArrayList por List

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.urbanpass.urbanpass.Models.Fences;
import com.urbanpass.urbanpass.Services.FencesService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;

@RestController
@RequestMapping("api/fences")
public class FencesControl {

    @Autowired
    FencesService fencesService;

    // Obtener todas las vallas
    @GetMapping()
    public List<Fences> obtenerFences() {  // Cambié ArrayList por List
        return fencesService.obtenerFences();
    }

    // Guardar una valla
    @PostMapping()
    public Fences guardarFence(@RequestBody Fences fence) {
        return fencesService.guardarFence(fence);
    }

    // Obtener una valla por su ID
    @GetMapping(path = "/id/{id}")
    public Fences obtenerFencePorId(@PathVariable("id") Long id) {
        return fencesService.obtenerPorId(id);
    }

    // Buscar vallas por su código o identificador único
    @GetMapping(path = "/fenceCode")  // Cambié fenceId por fenceCode en la URL
    public List<Fences> obtenerFencePorFenceCode(@RequestParam("fencesCode") String fencesCode) {  // Cambié el nombre del parámetro
        return fencesService.obtenerPorFenceCode(fencesCode);  // Cambié el nombre del método
    }

    // Eliminar una valla por su ID
    @DeleteMapping(path = "/{id}")
    public boolean eliminarFence(@PathVariable("id") Long id) {
        return fencesService.eliminarFence(id);
    }
}
