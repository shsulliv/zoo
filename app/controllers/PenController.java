package controllers;

import play.mvc.Controller;
import play.mvc.Result;

import java.util.ArrayList;
import java.util.List;

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
    List<String> penTypes = new ArrayList<>();
    penTypes.add("Hybrid");
    penTypes.add("Aquatic");
    penTypes.add("Land");
    penTypes.add("Air");
    penTypes.add("Petting");
    //    List<Keeper> keepers = Ebean.find(Keeper.class).findList();
    //    List<String> penTypes = Ebean.find(Keeper.class).findList(); ?????
    return ok(views.html.pens.form.render(penTypes));
  }
}
