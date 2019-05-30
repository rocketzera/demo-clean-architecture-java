package io.github.rocketzera.cleanarchitecture.adapter.controller.model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import io.github.rocketzera.cleanarchitecture.domain.type.Color;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CarDTO {
	
	private Long id;
	
	@NotBlank
	@ApiModelProperty(example = "Maverick")
	private String name;

	@NotBlank
	@ApiModelProperty(example = "Dominus")
	private String model;

	@NotNull
	private Color color;
	
}
