/*
**	@author Youness Zioual
*/

public class WeatherProvider {
	private static WeatherProvider SingleInstance = null;
	private final String[] weather = {"rain", "snow", "fog", "sun"};

	private WeatherProvider() {
	}

	public static WeatherProvider getInstance() {
		if (SingleInstance == null) {
			SingleInstance = new WeatherProvider();
		}
		return SingleInstance;
	}

	public String getCurrentWeather(Coordinates p_coordinates) {
		int sum = p_coordinates.getLongitude() +  p_coordinates.getLatitude() + p_coordinates.getHeight();
		if (sum > 50 && sum < 100) {
			return this.weather[0];
		} else if (sum < 50 ) {
			return this.weather[1];
		} else if (sum > 100 && sum < 200) {
			return this.weather[2];
		} else {
			return this.weather[4];
		}
	}
}
