package Simulation.Weather;

import Simulation.Coordinates;

public class WeatherProvider {
    private static WeatherProvider weatherProvider;
    private String[] weather;
    private int[][][] map;
    private static final int LONGITUDE_MAX = 360;
    private static final int LATITUDE_MAX = 360;
    private static final int HEIGHT_MAX = 100;

    private WeatherProvider() {
        this.weather = new String[]{
            "SUN",
            "RAIN",
            "FOG",
            "SNOW"
        };

        this.map = new int[HEIGHT_MAX][LATITUDE_MAX][LONGITUDE_MAX];
        for ( int h = 0 ; h < HEIGHT_MAX ; ++h ) {
            for ( int y = 0 ; y < LATITUDE_MAX ; ++y ) {
                for ( int x = 0 ; x < LONGITUDE_MAX ; ++x ) {
                    this.map[h][y][x] = (int)Math.random() * 4;
                }
            }
        }
    }

    public static WeatherProvider getProvider() {
        if ( weatherProvider == null ) {
            weatherProvider = new WeatherProvider();
        }
        return weatherProvider;
    }

    public String getCurrentWeather(Coordinates coordinates) {
        int lat = coordinates.getLatitude();
        int lon = coordinates.getLatitude();
        int height = coordinates.getHeight();

        return this.weather[ this.map[height][lat][lon] ];
    }
}
