/*
**	@author Youness Zioual
*/


public class Coordinates {
	private static int longitude;

	private static int latitude;
	private static int height;

	Coordinates(int p_longitude, int p_latitude, int p_height) {
		longitude = p_longitude;
		latitude = p_latitude;
		height = p_height;
	}

	public static void setLongitude(int longitude) {
		Coordinates.longitude = longitude;
	}

	public static void setLatitude(int latitude) {
		Coordinates.latitude = latitude;
	}

	public static void setHeight(int height) {
		Coordinates.height = height;
	}

	public int getLongitude() {
		return longitude;
	}

	public int getLatitude() {
		return latitude;
	}

	public int getHeight() {
		return height;
	}
}
