/*
**	@author Youness Zioual
*/

public class Helicopter extends Aircraft {
	Helicopter(long id, String name, Coordinates coordinates) {
        super(id, name, coordinates);
	}

	@Override
	public void updateConditions() {
		String weather = this.weatherTower.getWeather(coordinates);

		switch (weather.toLowerCase()) {
			case "sun" -> {
				this.log("Helicopter", "Oh today's sunny!!!!!");
				Coordinates.setLongitude(coordinates.getLongitude() + 10);
                Coordinates.setHeight(Math.min(coordinates.getHeight() + 2, 100));
			}
			case "rain" -> {
				this.log("Helicopter", "It's a rainy day!");
				Coordinates.setLongitude(coordinates.getLongitude() + 5);
			}
			case "fog" -> {
				this.log("Helicopter", "Oh My days! we're going through a fog!");
				Coordinates.setLongitude(Math.min(coordinates.getLongitude() + 1, 100));
			}
			case "snow" -> {
				this.log("Helicopter", "It's a snowy day!");
				Coordinates.setHeight(coordinates.getHeight() - 12);
				if (coordinates.getHeight() <= 0) {
					this.weatherTower.unregister(this);
					System.out.println("Tower says: Helicopter(" + id + "): unregistered from the weather tower.");
				}
			}
		}
	}
}
