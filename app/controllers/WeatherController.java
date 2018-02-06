package controllers;

import net.aksingh.owmjapis.api.APIException;
import net.aksingh.owmjapis.core.OWM;
import net.aksingh.owmjapis.model.CurrentWeather;
import play.mvc.Controller;
import play.mvc.Result;

public class WeatherController extends Controller {
  private static final String API_KEY = "5561a8e5d927fc2891afef569aaad7f9";
  private static final OWM weatherClient = new OWM(API_KEY);
  private static final double KELVIN = 273.15;

  public Result index() throws APIException {
    CurrentWeather weather = weatherClient.currentWeatherByCityName("London");
    return ok(views.html.weather.index.render(weather, KELVIN));
  }
}
