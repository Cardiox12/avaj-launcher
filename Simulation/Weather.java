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
                this.sun.execute(this.coordinates);
                break;
            case "RAIN":
                this.rain.execute(this.coordinates);;
                break;
            case "FOG":
                this.fog.execute(this.coordinates);
                break;
            case "SNOW":
                this.snow.execute(this.coordinates);
                break;
        }
    }
}
