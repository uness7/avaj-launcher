public class Node {
	private NodeType type;
	private int longitude;
	private int latitude;

	Node(NodeType type, int longitude, int latitude) {
		this.type = type;
		this.longitude = longitude;
		this.latitude = latitude;
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
}
