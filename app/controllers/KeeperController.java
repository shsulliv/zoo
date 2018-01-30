package controllers;

import play.mvc.Controller;
import play.mvc.Result;

import java.util.ArrayList;
import java.util.List;

public class KeeperController extends Controller {
  // index
  // show
  // new
  // create
  // delete
  // edit
  // update

  public Result index() {
    return ok(views.html.keepers.index.render());
  }

  public Result form() {
    List<String> penTypes = new ArrayList<>();
    penTypes.add("Hybrid");
    penTypes.add("Aquatic");
    penTypes.add("Land");
    penTypes.add("Air");
    penTypes.add("Petting");
    return ok(views.html.keepers.form.render(penTypes));
  }
}
