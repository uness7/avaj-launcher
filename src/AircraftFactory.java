/*************************************/
/*     @author Youness Zioual       */
/*************************************/

/*
 * Singleton
 */
public class AircraftFactory {
	private static AircraftFactory SingleInstance = null;

	private AircraftFactory() {
	}

	public static AircraftFactory getInstance() {
		if (this.SingleInstance == null) {
			this.SingleInstance = new AircraftFactory();
		}
		return this.SingleInstance;
	}

	// this method assumes that Helicopter, JetPlane, Balloon exist!
	publice Flyable newAircraft(
		String p_type, 
		String p_name, 
		Coordinates p_coordinates
	) {
		switch (p_type.toLowerCase()) {
			case "helicopter":
				return new Helicopter(p_name, p_coordinates);
			case "jetplane":
				return new JetPlane(p_name, p_coordinates);
			case "balloon":
				return new Balloon(p_name, p_coordinates);
			default:
				throw new IllegalArgumentException("Unknown aircraft");
		}
	}
}

