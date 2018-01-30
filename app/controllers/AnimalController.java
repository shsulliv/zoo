package controllers;

import models.Pen;
import models.Species;
import play.mvc.Controller;
import play.mvc.Result;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class AnimalController extends Controller {
  // index - list of all animals
  // show - won't use
  // new - form method
  // create
  // delete
  // edit
  // update

  public Result index() {
    return ok(views.html.animals.index.render());
  }

  public Result form() {
    Species a = new Species("Dog", "land", true, 20, 0, 0);
    Species b = new Species("Cat", "land", true, 10, 0, 0);
    a.id = UUID.randomUUID();
    b.id = UUID.randomUUID();
    //    List<Species> species = Ebean.find(Species.class).findList();
    List<Species> species = new ArrayList<>();
    species.add(a);
    species.add(b);

    //    List<Pen> pens = Ebean.find(Pen.class).findList();
    Pen c = new Pen("Pen C", "Hybrid", 20, 20, 0);
    Pen d = new Pen("Pen D", "land", 20, 0, 0);
    List<Pen> pens = new ArrayList<>();
    pens.add(c);
    pens.add(d);
    return ok(views.html.animals.form.render(species, pens));
  }

  public Result create() {
    // serialize the form somehow?
    // Create a new animal from the form data
    //    Animal animal = new Animal("Mr. Potato", "potato-toys", "potato-pen");
    //    animal.save();
    return redirect("/animal");
  }
}
