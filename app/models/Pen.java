package models;

import io.ebean.Model;
import play.data.validation.Constraints;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "pens")
public final class Pen extends Model {
  @Id public UUID id;

  @Constraints.Required public String penName;
  @Constraints.Required public String penType;
  @Constraints.Required public double landArea;
  @Constraints.Required public double waterArea;
  @Constraints.Required public double airArea;
  @Constraints.Required public double temperature;

  @OneToMany(mappedBy = "pen", cascade = CascadeType.ALL)
  public List<Animal> animals;

  @ManyToOne(cascade = CascadeType.ALL)
  @Constraints.Required
  public Keeper keeper;

  public Pen(
      String penName,
      String penType,
      double landArea,
      double waterArea,
      double airArea,
      double temperature) {
    this.penName = penName;
    this.penType = penType;
    this.landArea = landArea;
    this.waterArea = waterArea;
    this.airArea = airArea;
    this.temperature = temperature;
  }

  public boolean hasRoomFor(Animal animal) {
    if (!this.penType.equals(animal.species.penType)) {
      return false;
    }
    double availableLand = this.landArea;
    double availableWater = this.waterArea;
    double availableAir = this.airArea;

    for (Animal a : this.animals) {
      Species species = a.species;
      if (!species.canCohabitate(animal.species)) {
        return false;
      }
      availableLand = availableLand - species.landRequirement;
      availableWater = availableWater - species.waterRequirement;
      availableAir = availableAir - species.airRequirement;
    }
    return animal.species.landRequirement <= availableLand
        && animal.species.waterRequirement <= availableWater
        && animal.species.airRequirement <= availableAir
        && animal.species.temperature <= this.temperature;
  }

  @Override
  public String toString() {
    return penName;
  }
}
