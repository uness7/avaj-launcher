/*
**	@author Youness Zioual
*/

public class Ballon extends Aircraft {
	Ballon(long id, String name, Coordinates coordinates) {
        super(id, name, coordinates);
	}

	@Override
	public void updateConditions() {
		String weather = this.weatherTower.getWeather(coordinates);

		switch (weather.toLowerCase()) {
			case "sun" -> {
				this.log("Balloon", "We're out here having a blast in a sunny day inside the Balloon");
				Coordinates.setLongitude(coordinates.getLongitude() + 2);
				Coordinates.setHeight(Math.min(coordinates.getHeight() + 4, 100));
			}
			case "rain" -> {
				this.log("Balloon", "We're out here, I love rainy days! They calm me down!");
				Coordinates.setHeight(coordinates.getHeight() - 5);
				if (coordinates.getHeight() <= 0) {
					System.out.println("Tower says: Balloon(" + id + "): unregistered from the weather tower.");
					weatherTower.unregister(this);
				}
			}
			case "fog" -> {
				this.log("Balloon", "Foggy Balloony");
				Coordinates.setHeight(coordinates.getHeight() - 3);
				if (coordinates.getHeight() <= 0) {
					System.out.println("Tower says: Balloon(" + id + "): unregistered from the weather tower.");
					weatherTower.unregister(this);
				}
			}
			case "snow" -> {
				this.log("Balloon", "Snowy Balloony! We might freeze and dieeeee");
				Coordinates.setHeight(coordinates.getHeight() - 15);
				if (coordinates.getHeight() <= 0) {
					System.out.println("Tower says: Helicopter(" + id + "): unregistered from the weather tower.");
					weatherTower.unregister(this);
				}
			}
		}
	}
}
