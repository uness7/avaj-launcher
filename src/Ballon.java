/*************************************/
/*     @author Youness Zioual       */
/*************************************/

public class Ballon extends Aircraft {
	Ballon(long id, String name, Coordinates coordinates) {
        super(id, name, coordinates);
	}

	@Override
	public void updateConditions() {
		System.out.println("Balloon updated conditions");
	}
}
