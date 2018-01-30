package controllers;

import models.Keeper;
import play.mvc.Controller;
import play.mvc.Result;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class PenController extends Controller {
  // index
  // show
  // new
  // create
  // delete
  // edit
  // update

  public Result index() {
    return ok(views.html.pens.index.render());
  }

  public Result form() {
    Keeper s = new Keeper("Shannon", "Hybrid");
    s.id = UUID.randomUUID();
    Keeper r = new Keeper("Ricard", "Aquatic");
    r.id = UUID.randomUUID();
    List<Keeper> keepers = new ArrayList<>();
    keepers.add(s);
    keepers.add(r);
    List<String> penTypes = new ArrayList<>();
    penTypes.add("Hybrid");
    penTypes.add("Aquatic");
    penTypes.add("Land");
    penTypes.add("Air");
    penTypes.add("Petting");
    //    List<Keeper> keepers = Ebean.find(Keeper.class).findList();
    //    List<String> penTypes = Ebean.find(Keeper.class).findList(); ?????
    return ok(views.html.pens.form.render(keepers, penTypes));
  }
}
