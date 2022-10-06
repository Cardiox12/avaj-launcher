package Simulation;

public class JetPlane extends Aircraft implements Flyable {
    private WeatherTower weatherTower;

    JetPlane(String name, Coordinates coordinates) {
        super(name, coordinates);
    }

    public void updateConditions() {
        WeatherCommand sun = new WeatherCommand().increaseLatitude(10).increaseHeight(2);
        WeatherCommand rain = new WeatherCommand().increaseLatitude(5);
        WeatherCommand fog = new WeatherCommand().increaseLatitude(1);
        WeatherCommand snow = new WeatherCommand().increaseHeight(7);
        Weather weather = new Weather(coordinates, sun, rain, fog, snow);

        weather.execute(this.weatherTower.getWeather(this.coordinates));
    }

    public void registerTower(WeatherTower weatherTower) {
        this.weatherTower = weatherTower;
    }
}
