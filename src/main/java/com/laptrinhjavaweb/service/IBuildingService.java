package com.laptrinhjavaweb.service;

import java.util.List;
import java.util.Map;

import com.laptrinhjavaweb.builder.BuildingSearchBuilder;
import com.laptrinhjavaweb.dto.BuildingDTO;
import com.laptrinhjavaweb.paging.Pageble;

public interface IBuildingService {
	BuildingDTO save(BuildingDTO BuildingDTO);
	void delete(long id);
	<T> T findById(long id);
	List<BuildingDTO> search(BuildingDTO buildingDTO);
	List<BuildingDTO> findAll(BuildingSearchBuilder builder,Pageble pageble);
}
