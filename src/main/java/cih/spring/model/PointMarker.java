package cih.spring.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.Type;

import com.vividsolutions.jts.geom.Point;


@Entity
public class PointMarker  implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Type(type="org.hibernate.spatial.GeometryType")
	private Point point;
	@ManyToOne
	private CustomLayer layer;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Point getPoint() {
		return point;
	}

	public void setPoint(Point point) {
		this.point = point;
	}

	public CustomLayer getLayer() {
		return layer;
	}

	public void setLayer(CustomLayer layer) {
		this.layer = layer;
	}

	@Override
	public String toString() {
		return "PointMarker [id=" + id + ", point=" + point.toText() + ", layer="
				+ layer + "]";
	}

}
