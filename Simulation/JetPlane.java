package Simulation;

public class JetPlane extends Aircraft implements Flyable {
    private WeatherTower weatherTower;
    static private WeatherCommand sun = new WeatherCommand().increaseLatitude(10).increaseHeight(2);
    static private WeatherCommand rain = new WeatherCommand().increaseLatitude(5);
    static private WeatherCommand fog = new WeatherCommand().increaseLatitude(1);
    static private WeatherCommand snow = new WeatherCommand().increaseHeight(7);
    Weather weather;

    JetPlane(String name, Coordinates coordinates) {
        super(name, coordinates);
        super.setType("JetPlane");
        this.weather = new Weather(coordinates, sun, rain, fog, snow);
    }

    public void updateConditions() {
        this.weather.execute(this.weatherTower.getWeather(this.coordinates));
    }

    public void registerTower(WeatherTower weatherTower) {
        this.weatherTower = weatherTower;
    }
}
