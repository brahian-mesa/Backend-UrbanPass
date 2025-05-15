package com.urbanpass.urbanpass.Repository;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.urbanpass.urbanpass.Models.Stops;

@Repository
public interface StopsRepository extends CrudRepository<Stops, Long> {

    public abstract ArrayList<Stops> findByStopName(String stopName);

    public abstract Stops findByStopId(Long stopId);
}
