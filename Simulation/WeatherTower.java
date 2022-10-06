package Simulation;

public class WeatherTower extends Tower {
    public String getWeather(Coordinates coordinates) {
        return "";
    }

    void changeWeather() {
        this.conditionsChanged();
    }
}
