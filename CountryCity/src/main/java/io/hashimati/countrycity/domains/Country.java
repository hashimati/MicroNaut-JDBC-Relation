package io.hashimati.countrycity.domains;

import io.hashimati.countrycity.domains.Country;

import io.micronaut.data.annotation.*;

import lombok.*;
import javax.validation.constraints.*;

import java.util.*;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Builder
@MappedEntity("countries")
public class Country {

  @Id
  @GeneratedValue(GeneratedValue.Type.AUTO)
  @EqualsAndHashCode.Exclude
  private Long id;

  private String name;

  @Relation(mappedBy = "country", value = Relation.Kind.ONE_TO_MANY)
  private List<City> cities;

  @DateCreated private Date dateCreated;

  @DateUpdated private Date dateUpdated;
}