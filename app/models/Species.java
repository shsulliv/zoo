package models;

import io.ebean.Model;
import play.data.validation.Constraints;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "species")
public final class Species extends Model {
  @Id public UUID id;
  @Constraints.Required public String name;
  @Constraints.Required public String penType;
  @Constraints.Required public boolean petting;
  @Constraints.Required public double landRequirement;
  @Constraints.Required public double waterRequirement;
  @Constraints.Required public double airRequirement;

  @OneToMany(mappedBy = "species", cascade = CascadeType.ALL)
  public List<Animal> animals;

  public Species(
      String name,
      String penType,
      boolean petting,
      double landRequirement,
      double waterRequirement,
      double airRequirement) {
    this.name = name;
    this.penType = penType;
    this.petting = petting;
    this.landRequirement = landRequirement;
    this.waterRequirement = waterRequirement;
    this.airRequirement = airRequirement;
  }
}
