package Simulation;

public class Weather {
    private Coordinates coordinates;
    private WeatherCommand sun;
    private WeatherCommand rain;
    private WeatherCommand fog;
    private WeatherCommand snow;

    Weather(Coordinates coordinates, WeatherCommand sun, WeatherCommand rain, WeatherCommand fog, WeatherCommand snow) {
        this.coordinates = coordinates;
        this.sun = sun;
        this.rain = rain;
        this.fog = fog;
        this.snow = snow;
    }

    public void execute(String weather) {
        switch (weather) {
            case "SUN":
                break;
            case "RAIN":
                break;
            case "FOG":
                break;
            case "SNOW":
                break;
        }
    }
}
