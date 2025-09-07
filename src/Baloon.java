/*************************************/
/*     @author Youness Zioual       */
/*************************************/

public class Baloon extends Aircraft {
	public Baloon(
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
		System.out.println("Baloon updated conditions");
	}
}
