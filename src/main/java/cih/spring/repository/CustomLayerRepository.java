package cih.spring.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import cih.spring.model.CustomLayer;

public interface CustomLayerRepository extends CrudRepository<CustomLayer, Long>{
	List<CustomLayer> findByName(String name);
}
