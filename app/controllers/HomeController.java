package controllers;

import net.aksingh.owmjapis.api.APIException;
import net.aksingh.owmjapis.core.OWM;
import play.mvc.Controller;
import play.mvc.Result;

/** This controller contains an action to handle HTTP requests to the application's home page. */
public class HomeController extends Controller {
  private static final String API_KEY = "5561a8e5d927fc2891afef569aaad7f9";
  private static final OWM weatherClient = new OWM(API_KEY);
  /**
   * An action that renders an HTML page with a welcome message. The configuration in the <code>
   * routes</code> file means that this method will be called when the application receives a <code>
   * GET</code> request with a path of <code>/</code>.
   */
  public Result index() throws APIException {
    return ok(views.html.index.render(weatherClient.currentWeatherByCityName("Barcelona")));
  }
}
