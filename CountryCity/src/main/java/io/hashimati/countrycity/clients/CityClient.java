package io.hashimati.countrycity.clients;


import io.micronaut.context.annotation.Parameter;
import io.micronaut.http.annotation.*;
import io.micronaut.http.client.annotation.Client;
import javax.inject.Inject;
import io.reactivex.Flowable;
import io.reactivex.Single;
import io.hashimati.countrycity.domains.City;


@Client("/api/city")
public interface CityClient {

    @Post("/save")
    public City save(City city);

    @Get("/get")
    public City findById(@Parameter("id") long id);

    @Delete("/delete/{id}")
    public boolean deleteById(@PathVariable("id") long id);

    @Get("/findAll")
    public Iterable<City> findAll();

    @Put("/update")
    public City update(@Body City city);
}