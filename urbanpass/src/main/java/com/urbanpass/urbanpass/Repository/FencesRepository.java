package com.urbanpass.urbanpass.Repository;

import java.util.List;  // Cambiado de ArrayList a List

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.urbanpass.urbanpass.Models.Fences;

@Repository
public interface FencesRepository extends CrudRepository<Fences, Long> {  // Cambié el nombre de la clase a FencesRepository

    // Buscar por fenceId (Long)
    public List<Fences> findByFenceId(Long fenceId);  // Cambié ArrayList por List

    // Buscar por fenceCode (String)
    public List<Fences> findByFenceCode(String fenceCode);  // Cambié ArrayList por List y corregí el nombre de la variable
}
