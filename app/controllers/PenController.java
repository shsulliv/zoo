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
      ImmutableList.of("Dry", "Aquarium", "Aviary", "Hybrid", "Petting");

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
            Double.parseDouble(form.get("pen_air_area")));
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
    if (formHasErrors(form, id)) {
      return ok(views.html.pens.edit.render(pen, Ebean.find(Keeper.class).findList(), true));
    }
    pen.keeper = Ebean.find(Keeper.class, UUID.fromString(form.get("pen_keeper")));
    pen.save();
    return redirect("/pen");
  }

  private boolean formHasErrors(DynamicForm form, UUID id) {
    Pen pen = Ebean.find(Pen.class, id);
    Keeper keeper = Ebean.find(Keeper.class, UUID.fromString(form.get("pen_keeper")));

    if (!pen.penType.equals(keeper.penType)) {
      return true;
    }
    return false;
  }
}
