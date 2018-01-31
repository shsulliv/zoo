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
  @Constraints.Required public String speciesName;
  @Constraints.Required public String penType;
  @Constraints.Required public boolean isPetting;
  @Constraints.Required public double landRequirement;
  @Constraints.Required public double waterRequirement;
  @Constraints.Required public double airRequirement;

  @OneToMany(mappedBy = "species", cascade = CascadeType.ALL)
  public List<Animal> animals;

  public Species(
      String speciesName,
      String penType,
      boolean isPetting,
      double landRequirement,
      double waterRequirement,
      double airRequirement) {
    this.speciesName = speciesName;
    this.penType = penType;
    this.isPetting = isPetting;
    this.landRequirement = landRequirement;
    this.waterRequirement = waterRequirement;
    this.airRequirement = airRequirement;
  }

  @Override
  public String toString() {
    return speciesName;
  }
}
