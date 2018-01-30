package controllers;

import io.ebean.Ebean;
import models.Animal;
import models.Pen;
import models.Species;
import play.data.DynamicForm;
import play.data.FormFactory;
import play.mvc.Controller;
import play.mvc.Result;

import javax.inject.Inject;
import java.util.List;
import java.util.UUID;

public final class AnimalController extends Controller {
  @Inject private FormFactory formFactory;

  public Result index() {
    List<Animal> animals =
        Ebean.find(Animal.class).fetch("species").orderBy("species.speciesName").findList();
    return ok(views.html.animals.index.render(animals));
  }

  public Result form() {
    return ok(views.html.animals.form.render(Ebean.find(Species.class).findList()));
  }

  public Result create() {
    DynamicForm form = formFactory.form().bindFromRequest();
    Species species = Ebean.find(Species.class, UUID.fromString(form.get("animal_species")));
    Animal animal = new Animal(form.get("animal_name"), species);
    animal.save();
    return redirect("/animal");
  }

  public Result edit(UUID id) {
    Animal animal = Ebean.find(Animal.class).fetch("species").where().idEq(id).findOne();
    List<Pen> pens = Ebean.find(Pen.class).findList();
    return ok(views.html.animals.edit.render(animal, pens));
  }

  public Result update(UUID id) {
    DynamicForm form = formFactory.form().bindFromRequest();
    Animal animal = Ebean.find(Animal.class, id);
    animal.pen = Ebean.find(Pen.class, UUID.fromString(form.get("animal_pen")));
    animal.save();
    return redirect("/animal");
  }
}
