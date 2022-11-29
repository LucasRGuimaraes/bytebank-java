package br.com.basico.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.basico.model.Pessoa;

@Repository
public interface BasicoRepository extends JpaRepository<Pessoa, Long> {
	
	@Query("SELECT p FROM Pessoa p")
	List<Pessoa> listar();
	
}
