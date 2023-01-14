package Simulation;

public class Helicopter extends Aircraft implements Flyable {
    static private WeatherCommand sun = new WeatherCommand().increaseLongitude(10).increaseHeight(2);
    static private WeatherCommand rain = new WeatherCommand().increaseLongitude(5);
    static private WeatherCommand fog = new WeatherCommand().increaseLongitude(1);
    static private WeatherCommand snow = new WeatherCommand().decreaseHeight(12);
    private WeatherTower    weatherTower;
    private Weather         weather;


    Helicopter(String name, Coordinates coordinates) {
        super(name, coordinates);
        super.setType("Helicopter");
        this.weather = new Weather(coordinates, sun, rain, fog, snow);
    }

    public void updateConditions() {
        this.weather.execute(this.weatherTower.getWeather(this.coordinates));
    }

    public void registerTower(WeatherTower weatherTower) {
        this.weatherTower = weatherTower;
    }
}
