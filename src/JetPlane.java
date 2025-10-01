/*
**	@author Youness Zioual
*/

public class JetPlane extends Aircraft {
	public JetPlane(long p_id, String p_name, Coordinates p_coordinates) {
		super(p_id, p_name, p_coordinates);
	}

	@Override
	public void updateConditions() {
		System.out.println("JetPlane updated conditions");
	}
}
