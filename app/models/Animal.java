package models;

import io.ebean.Model;
import play.data.validation.Constraints;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.UUID;

@Entity
@Table(name = "animals")
public final class Animal extends Model {
  @Id public UUID id;

  @Constraints.Required public String name;
  @Constraints.Required public Species species;

  public Animal(String name, Species species) {
    this.name = name;
    this.species = species;
  }
}
