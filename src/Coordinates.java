/*************************************/
/*     @author Youness Zioual       */
/*************************************/


public public class Coordinates {
	private int longitude;
	private int latitude;
	private int height;

	Coordinates(int p_longitude, int p_latitude, int p_height) {
		this.longitude = p_longitude;
		this.latitude = p_latitude;
		this.height = p_height;
	}

	public getLongitude() {
		return this.longitude;
	}

	public getLattitude() {
		return this.latitude;
	}

	public getHeight() {
		return this.height;
	}
}
