package Simulation;

public class Baloon extends Aircraft implements Flyable {
    private WeatherTower weatherTower;

    Baloon(String name, Coordinates coordinates) {
        super(name, coordinates);
        super.setType("Baloon");
    }

    public void updateConditions() {
        WeatherCommand sun = new WeatherCommand().increaseLongitude(2).increaseHeight(4);
        WeatherCommand rain = new WeatherCommand().decreaseHeight(5);
        WeatherCommand fog = new WeatherCommand().decreaseHeight(3);
        WeatherCommand snow = new WeatherCommand().decreaseHeight(15);
        Weather weather = new Weather(coordinates, sun, rain, fog, snow);

        weather.execute(this.weatherTower.getWeather(this.coordinates));
    }

    public void registerTower(WeatherTower weatherTower) {
        this.weatherTower = weatherTower;
    }
}
