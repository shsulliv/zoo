package controllers;

import io.ebean.Ebean;
import models.Keeper;
import models.Pen;
import play.data.DynamicForm;
import play.data.FormFactory;
import play.mvc.Controller;
import play.mvc.Result;

import javax.inject.Inject;
import java.util.List;
import java.util.UUID;

public final class KeeperController extends Controller {
  @Inject private FormFactory formFactory;

  public Result index() {
    List<Keeper> keepers = Ebean.find(Keeper.class).fetch("pens").orderBy("keeperName").findList();
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

  public Result edit(UUID id) {
    Keeper keeper = Ebean.find(Keeper.class, id);
    List<Pen> pens = Ebean.find(Pen.class).findList();
    return ok(views.html.keepers.edit.render(keeper, pens));
  }

  public Result update(UUID id) {
    DynamicForm form = formFactory.form().bindFromRequest();
    Pen pen = Ebean.find(Pen.class, UUID.fromString(form.get("keeper_pen")));
    pen.keeper = Ebean.find(Keeper.class, id);
    pen.save();
    return redirect("/keeper");
  }
}
