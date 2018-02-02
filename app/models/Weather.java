package models;

public final class Weather {
  public String description;
  public double tempHigh;
  public double tempLow;
  String icon;

  public Weather(String description, double tempHigh, double tempLow, String icon) {
    this.description = description;
    this.tempHigh = tempHigh;
    this.tempLow = tempLow;
    this.icon = icon;
  }
}
