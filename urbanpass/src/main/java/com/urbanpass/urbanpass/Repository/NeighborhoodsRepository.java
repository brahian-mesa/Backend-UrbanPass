package com.urbanpass.urbanpass.Repository;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.urbanpass.urbanpass.Models.Neighborhoods;

@Repository
public interface NeighborhoodsRepository extends CrudRepository<Neighborhoods, Long> {

    public abstract ArrayList<Neighborhoods> findByNeighborhoodName(String neighborhoodName);
    public abstract ArrayList<Neighborhoods> findByNeighborhoodId(Long neighborhoodId);

}

