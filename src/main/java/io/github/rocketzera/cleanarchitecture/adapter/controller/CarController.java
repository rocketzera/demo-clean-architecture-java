package io.github.rocketzera.cleanarchitecture.adapter.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import io.github.rocketzera.cleanarchitecture.adapter.controller.model.CarDTO;
import io.github.rocketzera.cleanarchitecture.usecase.CreateCar;
import io.github.rocketzera.cleanarchitecture.usecase.FindCar;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(path = "/v1/car")
public class CarController {

    @Autowired
    private CreateCar createCar;

    @Autowired
    private FindCar findCar;

    @GetMapping
    @ApiOperation("Car list")
    public List<CarDTO> findAll() {
        return this.findCar.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @ApiOperation("Create car")
    public CarDTO save(@Valid @RequestBody CarDTO dto) {
        return this.createCar.create(dto);
    }

}
