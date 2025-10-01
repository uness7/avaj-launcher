/*************************************/
/*     @author Youness Zioual       */
/*************************************/

public class Aircraft extends Flyable {
	protected long id;
	protected String name;
	protected Coordinates coordinates;

	Aircraft(
		long p_id,
		String p_name,
		Coordinates p_coordinates,
	) {
		this.id = p_id;
		this.name = p_name;
		this.coordinates = p_coordinates;
	}

	public void updateConditions() {
		System.out.println(
				"Subclasses need to override this method");
	}
}
