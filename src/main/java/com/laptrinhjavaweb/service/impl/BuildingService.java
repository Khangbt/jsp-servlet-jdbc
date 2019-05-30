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
	
	public void delete(BuildingDTO buildingDTO) {
		BuildingConverter buildingConverter = new BuildingConverter();
		BuildingEntity buildingEntity = buildingConverter.convertToEntity(buildingDTO);
		buildingRepository.delete(buildingEntity);
	}

	@Override
	public BuildingDTO findById(BuildingDTO buildingDTO) {
		
		BuildingConverter buildingConverter = new BuildingConverter();
		BuildingEntity buildingEntity = buildingConverter.convertToEntity(buildingDTO);
		List<BuildingEntity> valuesEntity = buildingRepository.findById(buildingEntity);
		List<BuildingDTO> valuesDTO = new ArrayList<BuildingDTO>();
		
		for(BuildingEntity entity : valuesEntity) {
			valuesDTO.add(buildingConverter.convertToDTO(entity));
			
		}
		return valuesDTO.get(0);
		
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
	

