package com.laptrinhjavaweb.utils;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

import com.laptrinhjavaweb.enums.BuildingTypeEnum;
import com.laptrinhjavaweb.enums.DistrictEnum;

public class DataUtils {
	public static Map<String , String> getBuildingTypes() {
		Map<String , String> results = new HashMap<>();
		Stream.of(BuildingTypeEnum.values()).forEach(item -> {
			results.put(item.name(), item.getValue());
		});
		/* java 7
		for(BuildingTypeEnum item : BuildingTypeEnum.values()) {
			results.put(item.name(), item.getValue());
		}
		*/
		return results;
	}
	
	public static Map<String , String> getDistricts() {
		Map<String , String> results = new HashMap<>();
		/* java 8
		Stream.of(DistrictEnum.values()).forEach(item -> {
			results.put(item.name(), item.getValue());
		});
		*/
		for(DistrictEnum item : DistrictEnum.values()) {
			results.put(item.name(), item.getValue());
		}
		
		return results;
	}
}
