package com.laptrinhjavaweb.service.impl;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.inject.Inject;

import com.laptrinhjavaweb.builder.BuildingSearchBuilder;
import com.laptrinhjavaweb.converter.BuildingConverter;
import com.laptrinhjavaweb.dto.BuildingDTO;
import com.laptrinhjavaweb.entity.BuildingEntity;
import com.laptrinhjavaweb.paging.Pageble;
import com.laptrinhjavaweb.repository.IBuildingRepository;
import com.laptrinhjavaweb.repository.impl.BuildingRepository;
import com.laptrinhjavaweb.service.IBuildingService;

public class BuildingService implements IBuildingService {
	
	@Inject
	private  IBuildingRepository buildingRepository;
	
	@Inject
	private   BuildingConverter buildingConverter;
	/*
	 * public static BuildingService getInstance() { return new BuildingService(); }
	 */
/*
	public BuildingService() {
		if(buildingRepository==null) {
			buildingRepository = new BuildingRepository();
		}
		
		if(buildingConverter==null) {
			buildingConverter = new BuildingConverter();
		}
		
	}
	*/


	@Override
	public BuildingDTO save(BuildingDTO buildingDTO) {
		//BuildingConverter buildingConverter = new BuildingConverter();
		BuildingEntity buildingEntity = buildingConverter.convertToEntity(buildingDTO);
		buildingEntity.setCreatedDate(new Timestamp(System.currentTimeMillis()));
		Long id = buildingRepository.insert(buildingEntity);
		return null;
	}

	public void delete(long id) {
		BuildingDTO buildingDTO = new BuildingDTO();
		//BuildingConverter buildingConverter = new BuildingConverter();
		BuildingEntity buildingEntity = buildingConverter.convertToEntity(buildingDTO);
		buildingRepository.delete(id);
	}

	@Override
	public <T> T findById(long id) {
	
		BuildingEntity valuesEntity = buildingRepository.findById(id);
		BuildingDTO valuesDTO = buildingConverter.convertToDTO(valuesEntity);
		return (T) valuesDTO;

	}

	public List<BuildingDTO> search(BuildingDTO buildingDTO) {
		
		BuildingEntity buildingEntity = buildingConverter.convertToEntity(buildingDTO);
		List<BuildingDTO> valuesDTO = new ArrayList<BuildingDTO>();
		List<BuildingEntity> valuesEntity = buildingRepository.search(buildingEntity);
		if (!valuesEntity.isEmpty()) {
			for (BuildingEntity entity : valuesEntity) {
				valuesDTO.add(buildingConverter.convertToDTO(entity));
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
		
		List<BuildingEntity> buildingEntities = buildingRepository.findAll(builder, pageble);
		/* java 7 
		List<BuildingDTO> results = new ArrayList<>();
		for(BuildingEntity item : buildingEntities) {
			BuildingDTO buildingDTO = getBuildingConverter().convertToDTO(item);
			results.add(buildingDTO);
		}*/	
		// java 8
		List<BuildingDTO> results = buildingEntities.stream().map(item -> buildingConverter.convertToDTO(item))
				.collect(Collectors.toList());
		return results;
	}

	

}
