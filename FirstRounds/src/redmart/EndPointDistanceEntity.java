package redmart;

public class EndPointDistanceEntity {
	private int distance;
	private int value;

	/**
	 * @param distance
	 * @param value
	 */
	public EndPointDistanceEntity(int distance, int value) {
		super();
		this.distance = distance;
		this.value = value;
	}

	/**
	 * @return the distance
	 */
	public int getDistance() {
		return distance;
	}
	/**
	 * @param distance the distance to set
	 */
	public void setDistance(int distance) {
		this.distance = distance;
	}

	/**
	 * @return the value
	 */
	public int getValue() {
		return value;
	}
	/**
	 * @param value the value to set
	 */
	public void setValue(int value) {
		this.value = value;
	}

}
