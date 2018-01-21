package models;

import io.ebean.Model;
import play.data.validation.Constraints;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.UUID;

@Entity
@Table(name = "species")
public final class Species extends Model {
  @Id public UUID id;
  @Constraints.Required public String name;
  @Constraints.Required public String type;
  @Constraints.Required public boolean petting;
  @Constraints.Required public double landRequirement;
  @Constraints.Required public double waterRequirement;
  @Constraints.Required public double airRequirement;

  public Species(
      String name,
      String type,
      boolean petting,
      double landRequirement,
      double waterRequirement,
      double airRequirement) {
    this.name = name;
    this.type = type;
    this.petting = petting;
    this.landRequirement = landRequirement;
    this.waterRequirement = waterRequirement;
    this.airRequirement = airRequirement;
  }
}
