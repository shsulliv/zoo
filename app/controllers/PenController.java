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

public final class PenController extends Controller {
  private static final List<String> PEN_TYPES =
      ImmutableList.of(
          "Dry", "Aquarium - Salt Water", "Aquarium - Fresh Water", "Aviary", "Hybrid", "Petting");

  @Inject private FormFactory formFactory;

  public Result index() {
    List<Pen> pens = Ebean.find(Pen.class).fetch("keeper").orderBy("keeper.keeperName").findList();
    return ok(views.html.pens.index.render(pens));
  }

  public Result form() {
    return ok(views.html.pens.form.render(PEN_TYPES));
  }

  public Result create() {
    DynamicForm form = formFactory.form().bindFromRequest();
    Pen pen =
        new Pen(
            form.get("pen_name"),
            form.get("pen_type"),
            Double.parseDouble(form.get("pen_land_area")),
            Double.parseDouble(form.get("pen_water_area")),
            Double.parseDouble(form.get("pen_air_area")),
            Double.parseDouble(form.get("pen_temperature")));
    pen.save();
    return redirect("/pen");
  }

  public Result edit(UUID id) {
    Pen pen = Ebean.find(Pen.class, id);
    List<Keeper> keepers = Ebean.find(Keeper.class).findList();
    return ok(views.html.pens.edit.render(pen, keepers, false));
  }

  public Result update(UUID id) {
    DynamicForm form = formFactory.form().bindFromRequest();
    Pen pen = Ebean.find(Pen.class, id);
    UUID keeperUuid = UUIDUtils.safeFromString(form.get("pen_keeper"));
    Keeper keeper = keeperUuid == null ? null : Ebean.find(Keeper.class, keeperUuid);
    if (cannotAssign(pen, keeper)) {
      return ok(views.html.pens.edit.render(pen, Ebean.find(Keeper.class).findList(), true));
    }
    pen.penName = form.get("pen_name");
    if (keeper != null) {
      pen.keeper = keeper;
      pen.save();
    }
    return redirect("/pen");
  }

  private boolean cannotAssign(Pen pen, Keeper keeper) {
    return keeper != null && !keeper.penType.equals(pen.penType);
  }
}
