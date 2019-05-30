package io.github.rocketzera.cleanarchitecture.usecase;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import io.github.rocketzera.cleanarchitecture.adapter.controller.model.CarDTO;
import io.github.rocketzera.cleanarchitecture.adapter.repository.CarRepository;
import io.github.rocketzera.cleanarchitecture.usecase.assembler.CarAssembler;

@Component
public class FindCar {

	@Autowired
	private CarRepository repository;
	
	public List<CarDTO> findAll() {
		return CarAssembler.adapt(repository.findAll());
	}
	
}
