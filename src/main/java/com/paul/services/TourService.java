package com.paul.services;

import com.paul.entities.Tour;
import com.paul.repositories.TourRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.HashSet;
import java.util.Set;

@Service
@Transactional
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

    public Tour getTourById(Long tourId) {
        return tourRep.findById(tourId).get();
    }

    public void deleteTourById(Long tourId) {
        tourRep.deleteById(tourId);
    }

}
