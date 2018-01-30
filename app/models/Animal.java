package models;

import io.ebean.Model;
import play.data.validation.Constraints;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "animals")
public final class Animal extends Model {
  @Id public UUID id;

  @Constraints.Required public String name;

  @ManyToOne(cascade = CascadeType.ALL)
  @Constraints.Required
  public Species species;

  @ManyToOne(cascade = CascadeType.ALL)
  @Constraints.Required
  public Pen pen;

  public Animal(String name, Species species, Pen pen) {
    this.name = name;
    this.species = species;
    this.pen = pen;
  }
}
