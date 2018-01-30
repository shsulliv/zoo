package controllers;

import io.ebean.Ebean;
import models.Animal;
import models.Species;
import play.data.DynamicForm;
import play.data.FormFactory;
import play.mvc.Controller;
import play.mvc.Result;

import javax.inject.Inject;
import java.util.UUID;

public final class AnimalController extends Controller {
  @Inject private FormFactory formFactory;

  public Result index() {
    return ok(views.html.animals.index.render());
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
}
