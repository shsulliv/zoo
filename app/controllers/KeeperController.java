package controllers;

import com.google.common.collect.ImmutableList;
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
  private static final List<String> PEN_TYPES =
      ImmutableList.of(
          "Dry", "Aquarium - Salt Water", "Aquarium - Fresh Water", "Aviary", "Hybrid", "Petting");

  @Inject private FormFactory formFactory;

  public Result index() {
    List<Keeper> keepers = Ebean.find(Keeper.class).fetch("pens").orderBy("keeperName").findList();
    return ok(views.html.keepers.index.render(keepers));
  }

  public Result form() {
    return ok(views.html.keepers.form.render(PEN_TYPES));
  }

  public Result create() {
    DynamicForm form = formFactory.form().bindFromRequest();
    Keeper keeper = new Keeper(form.get("keeper_name"), form.get("keeper_pen_type"));
    keeper.save();
    return redirect("/keeper");
  }

  public Result edit(UUID id) {
    Keeper keeper = Ebean.find(Keeper.class, id);
    List<Pen> pens = Ebean.find(Pen.class).findList();
    return ok(views.html.keepers.edit.render(keeper, pens, false));
  }

  public Result update(UUID id) {
    DynamicForm form = formFactory.form().bindFromRequest();
    Keeper keeper = Ebean.find(Keeper.class, id);
    UUID penUuid = UUIDUtils.safeFromString(form.get("keeper_pen"));
    Pen pen = penUuid == null ? null : Ebean.find(Pen.class, penUuid);
    if (cannotAssign(keeper, pen)) {
      return ok(views.html.keepers.edit.render(keeper, Ebean.find(Pen.class).findList(), true));
    }
    keeper.keeperName = form.get("keeper_name");
    keeper.save();
    if (pen != null) {
      pen.keeper = keeper;
      pen.save();
    }
    return redirect("/keeper");
  }

  private boolean cannotAssign(Keeper keeper, Pen pen) {
    return pen != null && !keeper.penType.equals(pen.penType);
  }
}
