/*
**	@author Youness Zioual
*/

public class AircraftFactory {
	private static AircraftFactory SingleInstance = null;
	private static long aircraftId = 1;

	private AircraftFactory() {
	}

	public static AircraftFactory getInstance() {
		if (SingleInstance == null) {
			SingleInstance = new AircraftFactory();
		}
		return SingleInstance;
	}

	public Flyable newAircraft(String p_type, String p_name, Coordinates p_coordinates) throws IllegalArgumentException {
        return switch (p_type.toLowerCase()) {
            case "helicopter" -> new Helicopter(aircraftId++, p_name, p_coordinates);
            case "jetplane" -> new JetPlane(aircraftId++, p_name, p_coordinates);
            case "balloon" -> new Ballon(aircraftId++, p_name, p_coordinates);
            default -> throw new IllegalArgumentException("Unknown aircraft");
        };
	}
}

