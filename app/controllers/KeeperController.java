package controllers;

import play.mvc.Controller;
import play.mvc.Result;

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
    return ok(views.html.keepers.form.render());
  }
}
