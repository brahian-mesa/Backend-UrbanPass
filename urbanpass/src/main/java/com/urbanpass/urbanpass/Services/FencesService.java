package com.urbanpass.urbanpass.Services;

import java.util.List;  // Cambié ArrayList a List, ya que ahora usas List en el repositorio

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.urbanpass.urbanpass.Models.Fences;
import com.urbanpass.urbanpass.Repository.FencesRepository;  // Cambié el nombre del repositorio a FencesRepository

@Service
public class FencesService {

    @Autowired
    FencesRepository fencesRepository;  // Cambié FencesRepositorys a FencesRepository

    // Obtener todas las vallas
    public List<Fences> obtenerFences() {  // Cambié ArrayList a List
        return (List<Fences>) fencesRepository.findAll();  // Cambié el tipo de retorno a List
    }

    // Guardar una valla
    public Fences guardarFence(Fences fence) {
        return fencesRepository.save(fence);
    }

    // Obtener una valla por su ID
    public Fences obtenerPorId(Long id) {
        return fencesRepository.findById(id).orElse(null);  // Simplifiqué el código para obtener el valor
    }

    // Buscar vallas por su código o identificador único
    public List<Fences> obtenerPorFenceCode(String fenceCode) {  // Cambié ArrayList por List y el nombre del parámetro
        return fencesRepository.findByFenceCode(fenceCode);  // Cambié el método a findByFenceCode
    }

    // Eliminar una valla por su ID
    public boolean eliminarFence(Long id) {
        try {
            fencesRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
