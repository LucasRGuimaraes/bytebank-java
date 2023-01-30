package br.com.basico.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.basico.model.Host;

public interface HostRepository extends JpaRepository<Host, Long> {
}
