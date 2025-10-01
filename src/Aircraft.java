/*
**	@author Youness Zioual
*/

public class Aircraft extends Flyable {
	protected static long id;
	protected static String name;
	protected static Coordinates coordinates;

	Aircraft(long p_id, String p_name, Coordinates p_coordinates) {
		id = p_id;
		name = p_name;
		coordinates = p_coordinates;
	}

	public void updateConditions() {
		/* THIS METHOD IS OVERRIDDEN BY SUB CLASSES */
	}
}