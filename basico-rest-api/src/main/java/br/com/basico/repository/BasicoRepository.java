package br.com.basico.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.basico.model.Pessoa;

@Repository
public interface BasicoRepository extends JpaRepository<Pessoa, Long> {
}
