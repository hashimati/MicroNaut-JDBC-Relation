package io.hashimati.countrycity.repositories;

import io.hashimati.countrycity.domains.Country;

import java.util.ArrayList;
import java.util.Optional;
import io.micronaut.data.annotation.*;
import io.micronaut.data.jdbc.annotation.JdbcRepository;
import io.micronaut.data.model.query.builder.sql.Dialect;
import io.micronaut.data.model.*;
import io.micronaut.data.repository.CrudRepository;

@JdbcRepository(dialect = Dialect.MYSQL)
public interface CountryRepository extends CrudRepository<Country, Long> {


    @Join(value = "cities", type = Join.Type.FETCH)
    public ArrayList<Country> findAll();

}