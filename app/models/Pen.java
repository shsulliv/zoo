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

  @Constraints.Required public String name;
  @Constraints.Required public String type;
  @Constraints.Required public double landArea;
  @Constraints.Required public double waterArea;
  @Constraints.Required public double airArea;

  @OneToMany(mappedBy = "pen", cascade = CascadeType.ALL)
  public List<Animal> animals;

  @ManyToOne(cascade = CascadeType.ALL)
  @Constraints.Required
  public Keeper keeper;

  public Pen(
      String name, String type, double landArea, double waterArea, double airArea, Keeper keeper) {
    this.name = name;
    this.type = type;
    this.landArea = landArea;
    this.waterArea = waterArea;
    this.airArea = airArea;
    this.keeper = keeper;
  }
}
