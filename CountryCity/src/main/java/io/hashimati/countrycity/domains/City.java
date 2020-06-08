package io.hashimati.countrycity.domains;

import io.hashimati.countrycity.domains.City;

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
@MappedEntity("cities")
public class City {

  @Id
  @GeneratedValue(GeneratedValue.Type.AUTO)
  @EqualsAndHashCode.Exclude
  private Long id;

  private String name;

  @MappedProperty("country")
  private Country country;

  @DateCreated private Date dateCreated;

  @DateUpdated private Date dateUpdated;
}