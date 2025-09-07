/*************************************/
/*     @author Youness Zioual       */
/*************************************/

public class WeatherTower extends Tower {
	WeatherProvider obj = WeatherProvider.getInstance();

	public String getWeather(Coordinates p_coordinates) {
		return obj.getCurrentWeather(p_coordinates);
	}

	public void changeWeather() {
	}
}

