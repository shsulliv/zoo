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
  @Constraints.Required public String size;

  public Pen(String name, String type, String size) {
    this.name = name;
    this.type = type;
    this.size = size;
  }
}
