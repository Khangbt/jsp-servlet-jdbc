package com.laptrinhjavaweb.service;

import java.util.List;

import com.laptrinhjavaweb.dto.BuildingDTO;

public interface IBuildingService {
	BuildingDTO save(BuildingDTO BuildingDTO);
	void delete(long id);
	<T> T findById(long id);
	List<BuildingDTO> search(BuildingDTO buildingDTO);
}
