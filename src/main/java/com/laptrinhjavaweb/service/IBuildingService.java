package com.laptrinhjavaweb.service;

import java.util.List;

import com.laptrinhjavaweb.dto.BuildingDTO;

public interface IBuildingService {
	BuildingDTO save(BuildingDTO BuildingDTO);
	void delete(BuildingDTO buildingDTO);
	BuildingDTO findById(BuildingDTO buildingDTO);
	List<BuildingDTO> search(BuildingDTO buildingDTO);
}
