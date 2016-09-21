package cih.spring.controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.annotation.JsonRawValue;
import com.vividsolutions.jts.geom.Geometry;
import com.vividsolutions.jts.geom.LineString;
import com.vividsolutions.jts.geom.Point;
import com.vividsolutions.jts.geom.Polygon;
import com.vividsolutions.jts.io.ParseException;
import com.vividsolutions.jts.io.WKTReader;

import cih.spring.model.CustomLayer;
import cih.spring.model.LineStringMarker;
import cih.spring.model.MarkerHandler;
import cih.spring.model.PointMarker;
import cih.spring.model.PolygonMarker;
import cih.spring.repository.CustomLayerRepository;
import cih.spring.repository.LineStringMarkerRepository;
import cih.spring.repository.PointMarkerRepository;
import cih.spring.repository.PolygonMarkerRepository;
import cih.spring.wrapper.CustomLayerWrapper;
import cih.spring.wrapper.MarkerHandlerWrapper;

@Controller
@RequestMapping("/layer")
public class CustomLayerController {
	@Autowired
	private PolygonMarkerRepository polyrepository;
	@Autowired
	private LineStringMarkerRepository linerepository;
	@Autowired
	private PointMarkerRepository pointrepository;
	@Autowired
	private CustomLayerRepository customrepository;

	// @CrossOrigin(origins = "http://localhost:8080")
	@RequestMapping(method = RequestMethod.POST, value = "/create", produces = "application/json")
	public @JsonRawValue @ResponseBody CustomLayer create(
			@RequestBody MarkerHandlerWrapper markerwrapper)
			throws SQLException, ParseException {
		System.out.println(markerwrapper);
		CustomLayer saved = customrepository.save(markerwrapper
				.getCustomLayer());
		for (MarkerHandler markerHandler : markerwrapper.getMarkers()) {
			if (markerHandler.getType().equals("Polygon")) {
				createPolygon(markerHandler, saved);
			} else if (markerHandler.getType().equals("Point")) {
				System.out.println(markerHandler.getWkt());
				createPoint(markerHandler, saved);
			} else if (markerHandler.getType().equals("LineString")) {
				createLineString(markerHandler, saved);
			}
		}
		return saved;
	}

	@RequestMapping(method = RequestMethod.GET, value = "/findPointsById", produces = "application/json")
	public @JsonRawValue @ResponseBody CustomLayerWrapper findPointsById(
			@RequestParam(value = "id") Long id) {
		Iterable<PointMarker> points = pointrepository.findAll();
		Iterable<PolygonMarker> polygons = polyrepository.findAll();
		Iterable<LineStringMarker> linestrings = linerepository.findAll();
		CustomLayer layer = customrepository.findOne(id);
		CustomLayerWrapper layerwrapper = new CustomLayerWrapper(layer, points, polygons, linestrings);
		return layerwrapper;
	}

	private PolygonMarker createPolygon(MarkerHandler marker, CustomLayer layer)
			throws SQLException, ParseException {
		PolygonMarker polygonMarker = new PolygonMarker();
		Polygon polygon = (Polygon) wktToGeometry(marker);
		polygonMarker.setPolygon(polygon);
		polygonMarker.setLayer(layer);
		PolygonMarker saved = polyrepository.save(polygonMarker);
		return saved;
	}


	private LineStringMarker createLineString(MarkerHandler marker,
			CustomLayer layer) throws SQLException, ParseException {
		LineStringMarker lineStringMarker = new LineStringMarker();
		LineString linestring = (LineString) wktToGeometry(marker);
		lineStringMarker.setLinestring(linestring);
		lineStringMarker.setLayer(layer);
		LineStringMarker saved = linerepository.save(lineStringMarker);
		return saved;
	}


	private PointMarker createPoint(MarkerHandler marker, CustomLayer layer)
			throws SQLException, ParseException {
		PointMarker pointMarker = new PointMarker();
		Point point = (Point) wktToGeometry(marker);
		pointMarker.setPoint(point);
		pointMarker.setLayer(layer);
		PointMarker saved = pointrepository.save(pointMarker);
		return saved;
	}
	
	private Geometry wktToGeometry(MarkerHandler marker) throws ParseException {
		WKTReader r = new WKTReader();
		return r.read(marker.getWkt());
	}

}
