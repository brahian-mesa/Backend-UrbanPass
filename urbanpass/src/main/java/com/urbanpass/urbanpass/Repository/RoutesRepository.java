package com.urbanpass.urbanpass.Repository;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.urbanpass.urbanpass.Models.Routes;

@Repository
public interface RoutesRepository extends CrudRepository<Routes, Long> {
    ArrayList<Routes> findByNombre(String nombre);

    ArrayList<Routes> findByOrigen(String origen);

    ArrayList<Routes> findByDestino(String destino);
}