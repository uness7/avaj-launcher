public class Node {
	private NodeType type;
	private int longitude;
	private int latitude;
	private String name;
	private int height;

	Node(NodeType type, String name, int longitude, int latitude, int height) {
		this.type = type;
		this.longitude = longitude;
		this.latitude = latitude;
		this.name = name;
		this.height = height;
	}

	public int getHeight() {
		return this.height;
	}

	public NodeType getType() {
		return this.type; 
	};

	public int getLongitude() {
		return this.longitude; 
	};

	public int getLatitude() {
		return this.latitude; 
	};

	public String getName() {
		return this.name;
	}

	public String toString() {
		return ("Type: " + this.getName() + "\n") +
		("Name: " + this.getType() + "\n") +
		("Longitude: " + this.getLongitude() + "\n") +
		("Latitude: " + this.getLatitude() + "\n") +
		("Height: " + this.getHeight() + "\n") ;
	}
}
