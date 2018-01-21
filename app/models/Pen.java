package models;

import io.ebean.Model;
import play.data.validation.Constraints;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
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

  public Pen(String name, String type, double landArea, double waterArea, double airArea) {
    this.name = name;
    this.type = type;
    this.landArea = landArea;
    this.waterArea = waterArea;
    this.airArea = airArea;
  }
}
