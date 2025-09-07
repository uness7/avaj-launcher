/*************************************/
/*     @author Youness Zioual       */
/*************************************/

public class Helicopter extends Aircraft {
	public Helicopter(
		long p_id, 
		String p_name, 
		Coordinates p_coordinates
	) {
		this.id = p_id;
		this.name = p_name;
		this.coordinates = p_coordinates;
	}

	@override
	public void updateConditions() {
		System.out.println("Helicopter updated conditions");
	}
}
