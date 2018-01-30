package models;

import io.ebean.Model;
import play.data.validation.Constraints;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "keepers")
public final class Keeper extends Model {
  @Id public UUID id;

  @Constraints.Required public String name;
  @Constraints.Required public String penType;

  @OneToMany(cascade = CascadeType.ALL, mappedBy = "keeper")
  public List<Pen> pens;

  public Keeper(String name, String penType) {
    this.name = name;
    this.penType = penType;
  }
}
