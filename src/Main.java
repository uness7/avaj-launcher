/*
**	@author Youness Zioual
*/

import java.util.LinkedList;

import static java.lang.System.exit;

public class Main {
	public static void main(String[] arg) {
		if (arg.length != 1) {
			System.out.println("Number of arguments given to avaj-launcher is not appropriate. Please add an input file!");
			exit(0);
		}

		try {
			LinkedList<String> list = Utils.parseFileToList(arg[0]);
			LinkedList<Node> res = Utils.parse(list);
			int numberOfIterations = res.getFirst().getHeight();
			/* numberOfIterations == height == longitude == latitude for the sake of simplifying the logic */
			AircraftFactory aircraftFactory = AircraftFactory.getInstance();
			LinkedList<Flyable> fleet = new LinkedList<>();

			for (Node current : res) {
				final Flyable aircraft;
				switch (current.getType()) {
					case BALOON -> {
						Coordinates coordinates = new Coordinates(current.getLongitude(), current.getLatitude(), current.getHeight());
						aircraft = aircraftFactory.newAircraft("Balloon", current.getName(), coordinates);
						fleet.add(aircraft);
					}
					case JETPLANE -> {
						Coordinates coordinates = new Coordinates(current.getLongitude(), current.getLatitude(), current.getHeight());
						aircraft = aircraftFactory.newAircraft("JetPlane", current.getName(), coordinates);
						fleet.add(aircraft);
					}
					case HELICOPTER -> {
						Coordinates coordinates = new Coordinates(current.getLongitude(), current.getLatitude(), current.getHeight());
						aircraft = aircraftFactory.newAircraft("Helicopter", current.getName(), coordinates);
						fleet.add(aircraft);
					}
					case FIRST_LINE -> {/* DO NOTHING */}
				}
			}

			/* SIMULATION STARTS HERE */
			launchSimulation(fleet, numberOfIterations);
		} catch (InvalidInputFile e) {
			System.out.println("File content is not valid");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public static void launchSimulation(LinkedList<Flyable> fleet, int numberOfIterations) {
		WeatherTower weatherTower = new WeatherTower();

		for (Flyable f : fleet) {
			Aircraft a = (Aircraft) f;
			System.out.print("Tower says: ");
			if (a.name.startsWith("B")) {
				System.out.println("Balloon#" + a.name + "(" + a.id + ") registered to weather tower.");
			} else if (a.name.startsWith("J")) {
				System.out.println("JetPlane#" + a.name + "(" + a.id + ") registered to weather tower.");
			} else if (a.name.startsWith("H")) {
				System.out.println("Helicopter#" + a.name + "(" + a.id + ") registered to weather tower.");
			}

			f.registerTower(weatherTower);
			weatherTower.register(f);
		}

		for (int i = 0; i < numberOfIterations; i++) {
			weatherTower.changeWeather();
		}
	}
}

