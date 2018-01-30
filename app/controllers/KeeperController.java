package controllers;

import io.ebean.Ebean;
import models.Keeper;
import play.data.DynamicForm;
import play.data.FormFactory;
import play.mvc.Controller;
import play.mvc.Result;

import javax.inject.Inject;
import java.util.List;

public final class KeeperController extends Controller {
  @Inject private FormFactory formFactory;

  public Result index() {
    List<Keeper> keepers = Ebean.find(Keeper.class).findList();
    return ok(views.html.keepers.index.render(keepers));
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
