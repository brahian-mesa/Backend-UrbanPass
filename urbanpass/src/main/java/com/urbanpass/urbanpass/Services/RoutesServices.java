package com.urbanpass.urbanpass.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import com.urbanpass.urbanpass.Models.Routes;
import com.urbanpass.urbanpass.Repository.RoutesRepository;

@Service
public class RoutesServices {

    @Autowired // conecta la clase UsersRepositorios
    RoutesRepository routeRepsitorys;

    public ArrayList<Routes> obtenerRoutes() {
        return (ArrayList<Routes>) routeRepsitorys.findAll();
    }

    public Routes guardarRoutes(Routes routes) {
        return routeRepsitorys.save(routes);
    }

    public Routes obtenerPorId(Long id) {
        return routeRepsitorys.findById(id).orElse(null);
    }

    public ArrayList<Routes> obtenerPorNombre(String routeName) {
        return routeRepsitorys.findByNombre(routeName);
    }

    public Routes obtenerPorCodigo(Long routeId) {
        return routeRepsitorys.findById(routeId).orElse(null);
    }

    public boolean eliminarRoutes(Long id) {
        try {
            routeRepsitorys.deleteById(id);
            return true;
        } catch (Exception err) {
            return false;
        }
    }
}