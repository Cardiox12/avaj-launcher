package Simulation;

public class Helicopter extends Aircraft implements Flyable {
    private WeatherTower weatherTower;

    Helicopter(String name, Coordinates coordinates) {
        super(name, coordinates);
    }

    public void updateConditions() {
        WeatherCommand sun = new WeatherCommand().increaseLongitude(10).increaseHeight(2);
        WeatherCommand rain = new WeatherCommand().increaseLongitude(5);
        WeatherCommand fog = new WeatherCommand().increaseLongitude(1);
        WeatherCommand snow = new WeatherCommand().decreaseHeight(12);
        Weather weather = new Weather(coordinates, sun, rain, fog, snow);

        weather.execute(this.weatherTower.getWeather(this.coordinates));
    }

    public void registerTower(WeatherTower weatherTower) {
        this.weatherTower = weatherTower;
    }
}
