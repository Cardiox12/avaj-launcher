package Simulation;

public class Baloon extends Aircraft implements Flyable {
    static private WeatherCommand sun = new WeatherCommand().increaseLongitude(2).increaseHeight(4);
    static private WeatherCommand rain = new WeatherCommand().decreaseHeight(5);
    static private WeatherCommand fog = new WeatherCommand().decreaseHeight(3);
    static private WeatherCommand snow = new WeatherCommand().decreaseHeight(15);
    private WeatherTower    weatherTower;
    private Weather         weather;

    Baloon(String name, Coordinates coordinates) {
        super(name, coordinates);
        super.setType("Baloon");
        this.weather = new Weather(coordinates, sun, rain, fog, snow);
    }

    public void updateConditions() {
        this.weather.execute(this.weatherTower.getWeather(this.coordinates));
    }

    public void registerTower(WeatherTower weatherTower) {
        this.weatherTower = weatherTower;
    }
}
