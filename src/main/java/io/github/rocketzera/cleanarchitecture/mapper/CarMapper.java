package io.github.rocketzera.cleanarchitecture.mapper;

import java.util.List;
import java.util.stream.Collectors;

import io.github.rocketzera.cleanarchitecture.adapter.controller.model.CarDTO;
import io.github.rocketzera.cleanarchitecture.adapter.repository.model.CarEntity;
import io.github.rocketzera.cleanarchitecture.domain.model.Car;

public class CarMapper {

    public static Car toUseCase(CarDTO dto) {
        if (dto == null) {
            return null;
        }
        return Car.builder().id(dto.getId()).name(dto.getName()).model(dto.getModel()).color(dto.getColor()).build();
    }
    
    public static Car toUseCase(CarEntity entity) {
        if (entity == null) {
            return null;
        }
        return Car.builder().id(entity.getId()).name(entity.getName()).model(entity.getModel()).color(entity.getColor()).build();
    }
    
    public static CarEntity toRepository(Car domain) {
        if (domain == null) {
            return null;
        }
        return CarEntity.builder().id(domain.getId()).name(domain.getName()).model(domain.getModel()).color(domain.getColor()).build();
    }

    public static CarDTO toPresenter(Car domain) {
        if (domain == null) {
            return null;
        }
        return CarDTO.builder().id(domain.getId()).name(domain.getName()).model(domain.getModel())
                .color(domain.getColor()).build();
    }

    public static List<CarDTO> toPresenter(List<Car> list) {
        return list.stream().map(CarMapper::toPresenter).collect(Collectors.toList());
    }

    public static List<Car> toUseCase(List<CarEntity> list) {
        return list.stream().map(CarMapper::toUseCase).collect(Collectors.toList());
    }

}
