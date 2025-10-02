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
		return weather[sum % 4];
	}
}
