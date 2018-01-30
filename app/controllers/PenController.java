package controllers;

import models.Pen;
import play.data.DynamicForm;
import play.data.FormFactory;
import play.mvc.Controller;
import play.mvc.Result;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

public final class PenController extends Controller {
  @Inject private FormFactory formFactory;

  public Result index() {
    return ok(views.html.pens.index.render());
  }

  public Result form() {
    List<String> penTypes = new ArrayList<>();
    penTypes.add("Dry");
    penTypes.add("Aquarium");
    penTypes.add("Aviary");
    penTypes.add("Hybrid");
    penTypes.add("Petting");
    return ok(views.html.pens.form.render(penTypes));
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
}
