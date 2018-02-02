package models;

public final class Weather {
  public String description;
  public double tempHigh;
  public double tempLow;
  String icon;
  private String API_KEY = "5561a8e5d927fc2891afef569aaad7f9";

  public Weather(String description, double tempHigh, double tempLow, String icon) {
    this.description = description;
    this.tempHigh = tempHigh;
    this.tempLow = tempLow;
    this.icon = icon;
  }
}
