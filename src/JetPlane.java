/*
**	@author Youness Zioual
*/

public class JetPlane extends Aircraft {
	public JetPlane(long p_id, String p_name, Coordinates p_coordinates) {
		super(p_id, p_name, p_coordinates);
	}

	@Override
	public void updateConditions() {
		String weather = this.weatherTower.getWeather(coordinates);

		switch (weather.toLowerCase()) {
			case "sun" -> {
				this.log("JetPlane", "Oh my god! we're living our best flight ever in this beautiful sunny weather!");
				Coordinates.setLatitude(coordinates.getLatitude() + 10);
				Coordinates.setHeight(Math.min(coordinates.getHeight() + 2, 100));
			}
			case "rain" -> {
				this.log("JetPlane", "We might have a slippery landing, cuz it's pouring down profusely");
				Coordinates.setLatitude(coordinates.getLatitude() + 5);
			}
			case "fog" -> {
				this.log("JetPlane", "Oh shoot, it's foggy today, I hate fogs!!");
				Coordinates.setLatitude(coordinates.getLatitude() + 1);
			}
			case "snow" -> {
				this.log("JetPlane", "Dang it's snowy, tell joey!");
				Coordinates.setHeight(coordinates.getHeight() - 7);
				if (coordinates.getHeight() <= 0) {
					System.out.println("Tower says: Helicopter(" + id + "): unregistered from the weather tower.");
					weatherTower.unregister(this);
				}
			}
		}
	}
}
