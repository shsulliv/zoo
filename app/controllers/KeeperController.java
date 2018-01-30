package controllers;

import models.Keeper;
import play.data.DynamicForm;
import play.data.FormFactory;
import play.mvc.Controller;
import play.mvc.Result;

import javax.inject.Inject;

public final class KeeperController extends Controller {
  @Inject private FormFactory formFactory;

  public Result index() {
    return ok(views.html.keepers.index.render());
  }

  public Result form() {
    return ok(views.html.keepers.form.render());
  }

  public Result create() {
    DynamicForm form = formFactory.form().bindFromRequest();
    Keeper keeper = new Keeper(form.get("keeper_name"));
    keeper.save();
    return redirect("/keeper");
  }
}
