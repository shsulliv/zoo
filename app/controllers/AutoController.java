package controllers;

import io.ebean.Ebean;
import models.Animal;
import models.Keeper;
import models.Pen;
import play.mvc.Controller;
import play.mvc.Result;

import java.util.List;

public class AutoController extends Controller {

  public Result autoAssign() {
    List<Animal> animals = Ebean.find(Animal.class).findList();
    List<Pen> pens = Ebean.find(Pen.class).findList();
    List<Keeper> keepers = Ebean.find(Keeper.class).findList();
    assignPens(animals, pens);
    assignKeepers(pens, keepers);
    return redirect("/animal");
  }

  private void assignPens(List<Animal> animals, List<Pen> pens) {
    for (Animal animal : animals) {
      if (animal.pen == null) {
        for (Pen pen : pens) {
          if (pen.hasRoomFor(animal)) {
            animal.pen = pen;
            animal.save();
            pen.animals.add(animal);
          }
        }
      }
    }
  }

  private void assignKeepers(List<Pen> pens, List<Keeper> keepers) {
    for (Pen pen : pens) {
      if (pen.keeper == null) {
        for (Keeper keeper : keepers) {
          if (pen.penType.equals(keeper.penType)) {
            pen.keeper = keeper;
            pen.save();
            keeper.pens.add(pen);
          }
        }
      }
    }
  }
}
