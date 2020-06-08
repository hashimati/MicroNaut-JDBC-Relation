package io.hashimati.countrycity.resources;


import io.micronaut.context.annotation.Parameter;
import io.micronaut.http.annotation.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;

import io.hashimati.countrycity.domains.City;
import io.hashimati.countrycity.services.CityService;


@Controller("/api/city")
public class CityController {

    private static final Logger log = LoggerFactory.getLogger(CityController.class);

    @Inject private CityService cityService;

    @Post("/save")
    public City save(@Body City city){
        log.info("Saving  City : {}", city);
        //TODO insert your logic here!

        //saving Object
        return cityService.save(city);
    }
    @Get("/get")
    public City findById(@Parameter("id") long id){
        return cityService.findById(id);
    }

    @Delete("/delete/{id}")
    public boolean deleteById(@PathVariable("id") long id){
        log.info("Deleting City by Id: {}", id);
        return  cityService.deleteById(id);
    }

    @Get("/findAll")
    public Iterable<City> findAll(){
        log.info("find All");
        return cityService.findAll();
    }

    @Put("/update")
    public City update(@Body City city)
    {
        log.info("update {}", city);
        return cityService.update(city);

    }
}