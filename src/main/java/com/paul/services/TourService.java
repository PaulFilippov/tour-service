package com.paul.services;

import com.paul.entities.Tour;
import com.paul.repositories.TourRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class TourService {

    @Autowired
    private TourRepository tourRep;

    public Set<Tour> getAllTour()
    {
        Set<Tour> allTours = new HashSet();
        //cast from Iterable in Set
        tourRep.findAll().iterator().forEachRemaining(allTours::add);
        return allTours;
    }

    public void addTour(Tour tour) {
        tourRep.save(tour);
    }

    public Tour getTourById(Long tourId) {
        return tourRep.findById(tourId).get();
    }

    public void deleteTourById(Long tourId) {
        tourRep.deleteById(tourId);
    }

}
