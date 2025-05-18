package com.urbanpass.urbanpass.Controls;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.urbanpass.urbanpass.Models.Routes;
import com.urbanpass.urbanpass.Services.RoutesServices;

@CrossOrigin(origins = "http://localhost:5173", allowCredentials = "true")
@RestController
@RequestMapping("api/routes")
public class RoutesControl {

    @Autowired
    RoutesServices routesServices;

    @GetMapping()
    public ArrayList<Routes> obtenerRoutes() {
        return routesServices.obtenerRoutes();
    }

    @PostMapping()
    public ResponseEntity<Routes> guardarRoutes(@RequestBody Routes routes) {
        try {
            // Validar que los campos de horario no sean nulos
            if (routes.getHorarioLunesASabado() == null || routes.getHorarioDomingoFestivo() == null) {
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }

            Routes savedRoute = routesServices.guardarRoutes(routes);
            return new ResponseEntity<>(savedRoute, HttpStatus.CREATED);
        } catch (Exception e) {
            e.printStackTrace(); // Para debug
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Routes> obtenerRoutePorId(@PathVariable("id") Long id) {
        Routes route = routesServices.obtenerPorId(id);
        if (route != null) {
            return new ResponseEntity<>(route, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping(path = "/nombre/{nombre}")
    public ResponseEntity<ArrayList<Routes>> obtenerRoutePorNombre(@PathVariable("nombre") String nombre) {
        ArrayList<Routes> routes = routesServices.obtenerPorNombre(nombre);
        if (!routes.isEmpty()) {
            return new ResponseEntity<>(routes, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping(path = "/codigo/{routeId}")
    public ResponseEntity<Routes> obtenerRoutePorCodigo(@PathVariable("routeId") Long routeId) {
        Routes route = routesServices.obtenerPorCodigo(routeId);
        if (route != null) {
            return new ResponseEntity<>(route, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Boolean> eliminarRoute(@PathVariable("id") Long id) {
        boolean wasDeleted = routesServices.eliminarRoutes(id);
        if (wasDeleted) {
            return new ResponseEntity<>(true, HttpStatus.OK);
        }
        return new ResponseEntity<>(false, HttpStatus.NOT_FOUND);
    }
}