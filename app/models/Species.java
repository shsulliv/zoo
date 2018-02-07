package models;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import io.ebean.Model;
import play.data.validation.Constraints;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "species")
public final class Species extends Model {
  private static final Map<String, Set<String>> COMPANIONS;

  static {
    COMPANIONS =
        new ImmutableMap.Builder<String, Set<String>>()
            .put("Dog", ImmutableSet.of("Goat"))
            .put("Goat", ImmutableSet.of("Dog"))
            .build();
  }

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

  public boolean canCohabitate(Species otherSpecies) {
    return COMPANIONS
        .getOrDefault(this.speciesName, Collections.emptySet())
        .contains(otherSpecies.speciesName);
  }

  @Override
  public String toString() {
    return speciesName;
  }
}
