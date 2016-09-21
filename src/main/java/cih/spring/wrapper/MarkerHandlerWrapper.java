package cih.spring.wrapper;

import java.util.List;

import cih.spring.model.CustomLayer;
import cih.spring.model.MarkerHandler;

/*Embrulho*/
public class MarkerHandlerWrapper {
	private List<MarkerHandler> markers;
	private CustomLayer customLayer;

	public List<MarkerHandler> getMarkers() {
		return markers;
	}

	public void setMarkers(List<MarkerHandler> markers) {
		this.markers = markers;
	}

	public CustomLayer getCustomLayer() {
		return customLayer;
	}

	public void setCustomLayer(CustomLayer customLayer) {
		this.customLayer = customLayer;
	}

	@Override
	public String toString() {
		return "MarkerHandlerWrapper [markers=" + markers + ", customLayer="
				+ customLayer + "]";
	}

}
/* Exemplo de json 
 *{
	"markers": [{
		"wkt": "POINT(-52.998046875 -13.65025621588998)",
		"type": "Point"
	}, {
		"wkt": "POLYGON((-53.349609375 -22.82074373782892,-49.658203125 -19.708793717126106,-45.263671875 -24.11065740719684,-50.537109375 -27.43418918050107,-53.349609375 -22.82074373782892))",
		"type": "Polygon"
	}],
	"customLayer": {
		"name": "layer_test",
		"projection": "EPSG:4326"
	}
}

Host: localhost:8089
User-Agent: Mozilla/5.0 (X11; Ubuntu; Linux x86_64; rv:47.0) Gecko/20100101 Firefox/47.0
Accept: text/html,application/xhtml+xml,application/xml;q=0.9,*//*;q=0.8
Accept-Language: en-US,en;q=0.5
Accept-Encoding: gzip, deflate
Content-Type: application/json;charset=UTF-8
Referer: http://localhost:8089/layer/create
Content-Length: 373
Connection: keep-alive
*/