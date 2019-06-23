package com.laptrinhjavaweb.service.impl;

import java.lang.reflect.Field;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import com.laptrinhjavaweb.builder.BuildingSearchBuilder;
import com.laptrinhjavaweb.converter.BuildingConverter;
import com.laptrinhjavaweb.dto.BuildingDTO;
import com.laptrinhjavaweb.entity.BuildingEntity;
import com.laptrinhjavaweb.paging.Pageble;
import com.laptrinhjavaweb.repository.IBuildingRepository;
import com.laptrinhjavaweb.repository.impl.BuildingRepository;
import com.laptrinhjavaweb.service.IBuildingService;

public class BuildingService implements IBuildingService {

	private static IBuildingRepository buildingRepository;
	private  static BuildingConverter buildingConverter;
	/*
	 * public static BuildingService getInstance() { return new BuildingService(); }
	 */
/*
	public BuildingService() {
		buildingRepository = new BuildingRepository();
		buildingConverter = new BuildingConverter();
	}
	*/
	public static IBuildingRepository getBuildingRepository() {
		if(buildingRepository == null) {
			buildingRepository = new BuildingRepository();
		}
		return  buildingRepository;
	}
	public static BuildingConverter getBuildingConverter() {
		if(buildingConverter == null) {
			buildingConverter = new BuildingConverter();
		}
		return buildingConverter;
	}

	@Override
	public BuildingDTO save(BuildingDTO buildingDTO) {
		//BuildingConverter buildingConverter = new BuildingConverter();
		BuildingEntity buildingEntity = getBuildingConverter().convertToEntity(buildingDTO);
		buildingEntity.setCreatedDate(new Timestamp(System.currentTimeMillis()));
		Long id = getBuildingRepository().insert(buildingEntity);
		return null;
	}

	public void delete(long id) {
		BuildingDTO buildingDTO = new BuildingDTO();
		//BuildingConverter buildingConverter = new BuildingConverter();
		BuildingEntity buildingEntity = getBuildingConverter().convertToEntity(buildingDTO);
		getBuildingRepository().delete(id);
	}

	@Override
	public <T> T findById(long id) {
	
		BuildingEntity valuesEntity = getBuildingRepository().findById(id);
		BuildingDTO valuesDTO = getBuildingConverter().convertToDTO(valuesEntity);
		return (T) valuesDTO;

	}

	public List<BuildingDTO> search(BuildingDTO buildingDTO) {
		
		BuildingEntity buildingEntity = getBuildingConverter().convertToEntity(buildingDTO);
		List<BuildingDTO> valuesDTO = new ArrayList<BuildingDTO>();
		List<BuildingEntity> valuesEntity = getBuildingRepository().search(buildingEntity);
		if (!valuesEntity.isEmpty()) {
			for (BuildingEntity entity : valuesEntity) {
				valuesDTO.add(getBuildingConverter().convertToDTO(entity));
			}

			return valuesDTO;
			/* java 8
			valuesDTO = valuesEntity.stream().map(item -> getBuildingConverter().convertToDTO(item))
					.collect(Collectors.toList());
		*/
		}
		return null;
	}

	@Override
	public List<BuildingDTO> findAll(BuildingSearchBuilder builder, Pageble pageble) {
		
		List<BuildingEntity> buildingEntities = getBuildingRepository().findAll(builder, pageble);
		/* java 7 
		List<BuildingDTO> results = new ArrayList<>();
		for(BuildingEntity item : buildingEntities) {
			BuildingDTO buildingDTO = getBuildingConverter().convertToDTO(item);
			results.add(buildingDTO);
		}*/	
		// java 8
		List<BuildingDTO> results = buildingEntities.stream().map(item -> getBuildingConverter().convertToDTO(item))
				.collect(Collectors.toList());
		return results;
	}

	

}
