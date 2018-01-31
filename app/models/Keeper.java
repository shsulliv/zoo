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

  @Constraints.Required public String keeperName;

  @OneToMany(cascade = CascadeType.ALL, mappedBy = "keeper")
  public List<Pen> pens;

  public Keeper(String keeperName) {
    this.keeperName = keeperName;
  }

  @Override
  public String toString() {
    return keeperName;
  }
}
