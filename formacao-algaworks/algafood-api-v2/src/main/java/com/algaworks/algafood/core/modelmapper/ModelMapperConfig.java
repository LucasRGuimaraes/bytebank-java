package com.algaworks.algafood.core.modelmapper;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.algaworks.algafood.api.model.dto.EnderecoDTO;
import com.algaworks.algafood.domain.model.Endereco;

@Configuration
public class ModelMapperConfig {

  @Bean
  public ModelMapper modelMapper() {
    ModelMapper modelMapper = new ModelMapper();

    // modelMapper.createTypeMap(Restaurante.class, RestauranteDTO.class)
    // .addMapping(Restaurante::getTaxaFrete, RestauranteDTO::setPrecoFrete);

    var emderecoToModelTypeMap = modelMapper.createTypeMap(Endereco.class, EnderecoDTO.class);

    emderecoToModelTypeMap.<String>addMapping(
        endereco -> endereco.getCidade().getEstado().getNome(),
        (enderecoDTO, value) -> enderecoDTO.getCidade().setEstado(value));

    return modelMapper;

  }

}
