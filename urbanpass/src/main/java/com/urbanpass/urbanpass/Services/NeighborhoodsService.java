package com.urbanpass.urbanpass.Services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.urbanpass.urbanpass.Models.Neighborhoods;
import com.urbanpass.urbanpass.Repository.NeighborhoodsRepository;

@Service
public class NeighborhoodsService {

    @Autowired
    NeighborhoodsRepository neighborhoodsRepository;

    public ArrayList<Neighborhoods> obtenerNeighborhoods() {
        return (ArrayList<Neighborhoods>) neighborhoodsRepository.findAll();
    }

    public Neighborhoods guardarNeighborhoods(Neighborhoods neighborhoods) {
        return neighborhoodsRepository.save(neighborhoods);
    }

    public Neighborhoods obtenerPorId(Long id) {
        return neighborhoodsRepository.findById(id).orElse(null);
    }

    public ArrayList<Neighborhoods> obtenerPorNameNeighborhoods(String neighborhoodsName) {
        return neighborhoodsRepository.findByNeighborhoodName(neighborhoodsName);
    }

    public ArrayList<Neighborhoods> obtenerPorIdNeighborhoods(Long idNeighborhoods) {
        return neighborhoodsRepository.findByNeighborhoodId(idNeighborhoods);
    }

    public boolean eliminarNeighborhoods(Long id) {
        try {
            neighborhoodsRepository.deleteById(id);
            return true;
        } catch (Exception err) {
            return false;
        }
    }
}
