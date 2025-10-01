/*
**	@author Youness Zioual
*/

public class Helicopter extends Aircraft {
	Helicopter(long id, String name, Coordinates coordinates) {
        super(id, name, coordinates);

		weatherTower.register(this); // take off
		System.out.println("A Helicopter is taking off");
	}

	@Override
	public void updateConditions() {
		String weather = this.weatherTower.getWeather(coordinates);

		if (coordinates.getHeight() <= 0) { // landing
			System.out.println("A helicopter is landing");
			weatherTower.unregister(this);
		}

		switch (weather) {
			case "Sunny" -> {
				// longitude increases by 10
				// height increases by 2
			}
			case "Rainy" -> {
				// longitude increase by 5
			}
			case "Snow" -> {
				// Longitude increases by 12
			}
			case "Fog" -> {
				// Height increases by 1
			}
		}
	}
}
