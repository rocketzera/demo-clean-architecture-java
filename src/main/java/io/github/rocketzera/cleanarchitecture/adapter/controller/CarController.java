package io.github.rocketzera.cleanarchitecture.adapter.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import io.github.rocketzera.cleanarchitecture.adapter.controller.model.CarDTO;
import io.github.rocketzera.cleanarchitecture.domain.model.Car;
import io.github.rocketzera.cleanarchitecture.mapper.CarMapper;
import io.github.rocketzera.cleanarchitecture.usecase.DeleteCar;
import io.github.rocketzera.cleanarchitecture.usecase.FindCar;
import io.github.rocketzera.cleanarchitecture.usecase.PersistCar;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(path = "/v1/car")
public class CarController {

    @Autowired
    private PersistCar persistCar;

    @Autowired
    private FindCar findCar;
    
    @Autowired
    private DeleteCar deleteCar;

    @GetMapping
    @ApiOperation("Car list")
    public List<CarDTO> findAll() {
        return CarMapper.toPresenter(this.findCar.findAll());
    }

    @GetMapping("{id}")
    @ApiOperation("Car item")
    public CarDTO findById(@PathVariable Long id) {
        return CarMapper.toPresenter(this.findCar.findById(id));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @ApiOperation("Create car")
    public CarDTO save(@Valid @RequestBody CarDTO dto) {
        Car car = this.persistCar.create(CarMapper.toUseCase(dto));
        return CarMapper.toPresenter(car);
    }

    @PutMapping("{id}")
    @ApiOperation("Update car")
    public CarDTO update(@PathVariable Long id, @Valid @RequestBody CarDTO dto) {
        Car car = this.persistCar.update(id, CarMapper.toUseCase(dto));
        return CarMapper.toPresenter(car);
    }

    @DeleteMapping("{id}")
    @ApiOperation("Delete car")
    public void delete(@PathVariable Long id) {
        deleteCar.delete(id);
    }

}
