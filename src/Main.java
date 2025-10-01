/*
**	@author Youness Zioual
*/

import java.util.LinkedList;

public class Main {
	public static void main(String[] arg) {
		String fileName = "";

		if (arg.length != 1) {
			System.out.println("something is wrong");
			return ;
		}

		fileName = arg[0];

		Utils utils = new Utils();
		LinkedList<String> list = utils.parseFileToList(fileName);
        LinkedList<Node> res = utils.parse(list);

		AircraftFactory aircraftFactory = AircraftFactory.getInstance();

        for (Node current : res) {
			switch (current.getType()) {
				case BALOON -> {
					Coordinates coordinates = new Coordinates(current.getLongitude(), current.getLatitude(), current.getHeight());
					Flyable aircraft = aircraftFactory.newAircraft("Balloon", current.getName(), coordinates);
				}
                case JETPLANE -> {
					Coordinates coordinates = new Coordinates(current.getLongitude(), current.getLatitude(), current.getHeight());
					Flyable aircraft = aircraftFactory.newAircraft("JetPlane", current.getName(), coordinates);
				}
                case HELICOPTER -> {
					Coordinates coordinates = new Coordinates(current.getLongitude(), current.getLatitude(), current.getHeight());
					Flyable aircraft = aircraftFactory.newAircraft("Helicopter", current.getName(), coordinates);
                }
                case FIRST_LINE -> {
					break ;
                }
            }
        }
	}
}

