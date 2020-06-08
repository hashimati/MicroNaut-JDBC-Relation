package io.hashimati.countrycity.resources;


import io.hashimati.countrycity.domains.City;
import io.hashimati.countrycity.services.CityService;
import io.micronaut.context.annotation.Parameter;
import io.micronaut.http.annotation.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;

import io.hashimati.countrycity.domains.Country;
import io.hashimati.countrycity.services.CountryService;


@Controller("/api/country")
public class CountryController {

    private static final Logger log = LoggerFactory.getLogger(CountryController.class);

    @Inject private CountryService countryService;


    @Inject private CityService cityService;

    @Get("/test")
    public Country test(){

        Country country = new Country();
        country.setName("Saudi Arabia");
        country = countryService.save(country);
        City city = new City();
        city.setName("Saihat");
        city.setCountry(country);
        cityService.save((city));
        return country;

    }
    @Post("/save")
    public Country save(@Body Country country){
        log.info("Saving  Country : {}", country);
        //TODO insert your logic here!

        //saving Object
        return countryService.save(country);
    }
    @Get("/get")
    public Country findById(@Parameter("id") long id){
        return countryService.findById(id);
    }

    @Delete("/delete/{id}")
    public boolean deleteById(@PathVariable("id") long id){
        log.info("Deleting Country by Id: {}", id);
        return  countryService.deleteById(id);
    }

    @Get("/findAll")
    public Iterable<Country> findAll(){
        log.info("find All");
        return countryService.findAll();
    }

    @Put("/update")
    public Country update(@Body Country country)
    {
        log.info("update {}", country);
        return countryService.update(country);

    }
}