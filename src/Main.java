/*
**	@author Youness Zioual
*/

import java.util.LinkedList;

public class Main {
	public static void main(String[] arg) {
		System.out.println("Inside Simulation");
		String fileName = "";

		if (arg.length != 1) {
			System.out.println("something is wrong");
			return ;
		}

		fileName = arg[0];

		Utils utils = new Utils();
		LinkedList<String> list = utils.parseFileToList(fileName);
        LinkedList<Node> res = utils.parse(list);
		System.out.println(res.toString());
		AircraftFactory aircraftFactory = AircraftFactory.getInstance();

		LinkedList<Flyable> fleet = new LinkedList<>();
		int numberOfIterations = 25;

		for (Node current : res) {
			System.out.println("Producing aircrafts.....");
			switch (current.getType()) {
				case BALOON -> {
					Coordinates coordinates = new Coordinates(current.getLongitude(), current.getLatitude(), current.getHeight());
					Flyable aircraft = aircraftFactory.newAircraft("Balloon", current.getName(), coordinates);
					fleet.add(aircraft);
				}
                case JETPLANE -> {
					Coordinates coordinates = new Coordinates(current.getLongitude(), current.getLatitude(), current.getHeight());
					Flyable aircraft = aircraftFactory.newAircraft("JetPlane", current.getName(), coordinates);
					fleet.add(aircraft);
				}
                case HELICOPTER -> {
					Coordinates coordinates = new Coordinates(current.getLongitude(), current.getLatitude(), current.getHeight());
					Flyable aircraft = aircraftFactory.newAircraft("Helicopter", current.getName(), coordinates);
					fleet.add(aircraft);
				}
            }
        }

		launchSimulation(fleet, numberOfIterations);
	}
	public static void launchSimulation(LinkedList<Flyable> fleet, int numberOfIterations) {
		WeatherTower weatherTower = new WeatherTower();

		for (int i = 0; i < numberOfIterations; i++) {
			for (Flyable f : fleet) {
				f.registerTower(weatherTower);
				weatherTower.register(f);
				weatherTower.changeWeather();
			}
		}
	}
}

