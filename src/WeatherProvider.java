/*************************************/
/*     @author Youness Zioual       */
/*************************************/

public class WeatherProvider {
	private static WeatherProvider SingleInstance = null;
	private final String[] weather;

	private WeatherProvider(private String[] weather) {
		this.weather = weather;
	}

	// this fun needs Coordinates dep
	public void getCurrentWeather() {}

	public static WeatherProvider getInstance() {
		if (SingleInstance == null) {
			SingleInstance = new WeatherProvider();
		}
		return SingleInstance;
	}
}
