package com.algaworks.algafood.api.model.input;

import java.math.BigDecimal;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RestauranteInput {

  // @NotNull
  // @NotEmpty
  @NotBlank
  private String nome;

  // @DecimalMin("1")
	// @TaxaFrete(message = "")
	// @Multiplo(numero = 5)
  @PositiveOrZero(message = "{TaxaFrete.invalida}")
  @NotNull
  private BigDecimal taxaFrete;

  @Valid
  @NotNull
  private CozinhaIdInput cozinha;

}
