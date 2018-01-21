package models;

import io.ebean.Model;
import play.data.validation.Constraints;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.UUID;

@Entity
@Table(name = "keepers")
public final class Keeper extends Model {
  @Id public UUID id;

  @Constraints.Required public String name;
  @Constraints.Required public String type;

  public Keeper(String name, String type) {
    this.name = name;
    this.type = type;
  }
}
