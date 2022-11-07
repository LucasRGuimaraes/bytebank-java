package com.algaworks.algafood.infrastructure.repository.spec;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.lang.Nullable;

import com.algaworks.algafood.domain.model.Restaurante;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class RestauranteComNomeSemelhanteSpec implements Specification<Restaurante>{
  
  private String nome;

  @Override
  @Nullable
  public Predicate toPredicate(Root<Restaurante> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
    return criteriaBuilder.like(root.get("nome"), "%" + nome + "%");
  }
  
}
