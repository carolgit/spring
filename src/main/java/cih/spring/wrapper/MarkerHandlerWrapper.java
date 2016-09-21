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
