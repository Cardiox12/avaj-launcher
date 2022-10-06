package Simulation;

public class WeatherCommand {
    private int longitude;
    private int latitude;
    private int height;

    WeatherCommand() {
        this.longitude = 0;
        this.latitude = 0;
        this.height = 0;
    }

    public void execute(Coordinates coordinates) {
        coordinates.setHeight(coordinates.getHeight() + this.height);
        coordinates.setLongitude(coordinates.getLongitude() + this.longitude);
        coordinates.setLatitude(coordinates.getLatitude() + this.latitude);
    }

    public WeatherCommand increaseLatitude(int latitude) {
        this.latitude = latitude;
        return this;
    }

    public WeatherCommand increaseLongitude(int longitude) {
        this.longitude = longitude;
        return this;
    }

    public WeatherCommand increaseHeight(int height) {
        this.height = height;
        return this;
    }

    public WeatherCommand decreaseLatitude(int latitude) {
        this.latitude = -latitude;
        return this;
    }

    public WeatherCommand decreaseLongitude(int longitude) {
        this.longitude = -longitude;
        return this;
    }

    public WeatherCommand decreaseHeight(int height) {
        this.height = -height;
        return this;
    }
}
