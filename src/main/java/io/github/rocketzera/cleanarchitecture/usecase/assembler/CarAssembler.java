package io.github.rocketzera.cleanarchitecture.usecase.assembler;

import java.util.List;
import java.util.stream.Collectors;

import io.github.rocketzera.cleanarchitecture.adapter.controller.model.CarDTO;
import io.github.rocketzera.cleanarchitecture.domain.entity.Car;

public class CarAssembler {

	public static Car adapt(CarDTO dto) {
		if(dto == null) {
			return null;
		}
		
		return Car.builder()
				.id(dto.getId())
				.name(dto.getName())
				.model(dto.getModel())
				.color(dto.getColor())
				.build();
	}
	
	public static CarDTO adapt(Car entity) {
		if(entity == null) {
			return null;
		}
		
		return CarDTO.builder()
				.id(entity.getId())
				.name(entity.getName())
				.model(entity.getModel())
				.color(entity.getColor())
				.build();
	}

	public static List<CarDTO> adapt(List<Car> list) {
		return list.stream().map(CarAssembler::adapt).collect(Collectors.toList());
	}
	
}
