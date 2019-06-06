package com.laptrinhjavaweb.service.impl;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.laptrinhjavaweb.converter.BuildingConverter;
import com.laptrinhjavaweb.dto.BuildingDTO;
import com.laptrinhjavaweb.entity.BuildingEntity;
import com.laptrinhjavaweb.repository.IBuildingRepository;
import com.laptrinhjavaweb.repository.impl.BuildingRepository;
import com.laptrinhjavaweb.service.IBuildingService;

public class BuildingService implements IBuildingService{
	
	private IBuildingRepository buildingRepository;
	
	public BuildingService() {
		buildingRepository = new BuildingRepository();
	}
	
	@Override
	public BuildingDTO save(BuildingDTO buildingDTO) {
		BuildingConverter buildingConverter = new BuildingConverter();
		BuildingEntity buildingEntity = buildingConverter.convertToEntity(buildingDTO);
		buildingEntity.setCreatedDate(new Timestamp(System.currentTimeMillis()));
		Long id = buildingRepository.insert(buildingEntity);
		return null;
	}
	
	public void delete(long id) {
		BuildingDTO buildingDTO = new BuildingDTO();
		BuildingConverter buildingConverter = new BuildingConverter();
		BuildingEntity buildingEntity = buildingConverter.convertToEntity(buildingDTO);
		buildingRepository.delete(id);
	}

	@Override
	public <T> T findById(long id) {
		BuildingDTO buildingDTO = new BuildingDTO();
		BuildingConverter buildingConverter = new BuildingConverter();
		BuildingEntity buildingEntity = buildingConverter.convertToEntity(buildingDTO);
		BuildingEntity valuesEntity = buildingRepository.findById(id);
		BuildingDTO valuesDTO = buildingConverter.convertToDTO(valuesEntity);
		return (T) valuesDTO;
		
	}
	public List<BuildingDTO> search(BuildingDTO buildingDTO) {
		BuildingConverter buildingConverter = new BuildingConverter();
		BuildingEntity buildingEntity = buildingConverter.convertToEntity(buildingDTO);
		List<BuildingDTO> valuesDTO = new ArrayList<BuildingDTO>();
		List<BuildingEntity> valuesEntity = buildingRepository.search(buildingEntity);
		if(!valuesEntity.isEmpty()) {
		for(BuildingEntity entity : valuesEntity) {
			valuesDTO.add(buildingConverter.convertToDTO(entity));
		}
		
		return valuesDTO;
	}
		return null;
	}
	
	}
	

