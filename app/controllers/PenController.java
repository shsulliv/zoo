package controllers;

import com.google.common.collect.ImmutableList;
import io.ebean.Ebean;
import models.Pen;
import play.data.DynamicForm;
import play.data.FormFactory;
import play.mvc.Controller;
import play.mvc.Result;

import javax.inject.Inject;
import java.util.List;

public final class PenController extends Controller {
  private static final List<String> PEN_TYPES =
      ImmutableList.of("Dry", "Aquarium", "Aviary", "Hybrid", "Petting");

  @Inject private FormFactory formFactory;

  public Result index() {
    List<Pen> pens = Ebean.find(Pen.class).findList();
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

  public Result edit() {
    return ok(views.html.pens.edit.render());
  }

  public Result update() {
    return redirect("/pen");
  }
}
