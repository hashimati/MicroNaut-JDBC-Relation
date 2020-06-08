package io.hashimati.countrycity.services;


import javax.inject.Inject;
import javax.inject.Singleton;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.transaction.Transactional;
import io.hashimati.countrycity.domains.City;
import io.hashimati.countrycity.repositories.CityRepository;


@Singleton
@Transactional
public class CityService {

    private static final Logger log = LoggerFactory.getLogger(CityService.class);
    @Inject private CityRepository cityRepository;

    public City save(City city){
        log.info("Saving  City : {}", city);
        //TODO insert your logic here!
        //saving Object
        cityRepository.save(city);
        return city;
    }

    public City findById(long id){
        log.info("Finding City By Id: {}", id);
        return cityRepository.findById(id).orElse(null);
    }


    public boolean deleteById(long id){
        log.info("Deleting City by Id: {}", id);
        try{
            cityRepository.deleteById(id);
            log.info("Deleted City by Id: {}", id);
            return true;
        }
        catch(Exception ex)
        {
            log.info("Failed to delete City by Id: {}", id);
            ex.printStackTrace();
            return false;
        }
    }

    public Iterable<City> findAll() {
        log.info("Find All");
      return  cityRepository.findAll();
    }

    public boolean existsById(Long id)
    {
        log.info("Check if id exists: {}", id);
        return  cityRepository.existsById(id);

    }
    public City update(City city)
    {
        log.info("update {}", city);
        return cityRepository.update(city);

    }

}