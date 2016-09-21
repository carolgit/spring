package cih.spring.model;

public class MarkerHandler {
	private String wkt;
	private String type;

	public String getWkt() {
		return wkt;
	}

	public void setWkt(String wkt) {
		this.wkt = wkt;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "MarkerHandler [wkt=" + wkt + ", type=" + type + "]";
	}
 
}