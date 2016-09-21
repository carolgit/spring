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
/* Exemplo de json 
 *{
	"markerwrapper": {
		"markers": [{
			"wkt": "POINT(-105.01621  39.57422)",
			"type": "Point"
		}, {
			"wkt": "POLYGON(  -109.0283203125 36.98500309285596,-109.0283203125 40.97989806962013,-102.06298828125 40.97989806962013,-102.06298828125 37.00255267215955,-109.0283203125 36.98500309285596)",
			"type ": "Polygon "
		}],
		"customLayer ": {
			"name ": "layer_test ",
			"projection ": "EPSG: 4326 "
		}
	}
}
*/