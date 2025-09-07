/*************************************/
/*     @author Youness Zioual       */
/*************************************/

/* 
 * Singleton 
 */
public class WeatherProvider {
	private static WeatherProvider SingleInstance = null;
	private final String[] weather = {"SNOW", "RAIN", "FOG", "SUN"};
 
	private WeatherProvider(private String[] weather) {
		this.weather = weather;
	}

	public String getCurrentWeather(Coordinates p_coordinates) {
		int sum = p_coordinates.getLongitude() + p_coordinates.getLatitude() + p_coordinates.getHeight();
		return weather[sum % weather.length];
	}

	public static WeatherProvider getInstance() {
		if (SingleInstance == null) {
			SingleInstance = new WeatherProvider();
		}
		return SingleInstance;
	}
}
