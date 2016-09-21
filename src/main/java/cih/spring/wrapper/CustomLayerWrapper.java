package cih.spring.wrapper;

import java.util.ArrayList;
import java.util.List;

import cih.spring.model.CustomLayer;
import cih.spring.model.LineStringMarker;
import cih.spring.model.PointMarker;
import cih.spring.model.PolygonMarker;

public class CustomLayerWrapper {
	private CustomLayer layer;
	private List<String> wkts;

	public CustomLayerWrapper(CustomLayer layer, Iterable<PointMarker> points,
			Iterable<PolygonMarker> polygons,
			Iterable<LineStringMarker> linestrings) {
		List<String> wkts = new ArrayList<>();
		for (PointMarker point : points) {
			if (layer.getId().equals(point.getLayer().getId())) {
				wkts.add(point.getPoint().toText());
			}
		}
		for (PolygonMarker polygon : polygons) {
			if (layer.getId().equals(polygon.getLayer().getId())) {
				wkts.add(polygon.getPolygon().toText());
			}
		}
		for (LineStringMarker line : linestrings) {
			if (layer.getId().equals(line.getLayer().getId())) {
				wkts.add(line.getLinestring().toText());
			}
		}
		this.layer = layer;
		this.wkts = wkts;
	}

	public CustomLayer getLayer() {
		return layer;
	}

	public void setLayer(CustomLayer layer) {
		this.layer = layer;
	}

	public List<String> getWkts() {
		return wkts;
	}

	public void setWkts(List<String> wkts) {
		this.wkts = wkts;
	}

}
