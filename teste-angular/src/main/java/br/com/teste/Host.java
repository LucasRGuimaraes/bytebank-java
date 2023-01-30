package br.com.teste;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class Host {
	
	@Id
	@EqualsAndHashCode.Include
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "host_tx_name", nullable = false)
	private String nome;
	
	@Column(name = "host_tx_password", nullable = false)
	private String usuario;

	@Column(name = "host_tx_password", nullable = false)
	private String senha;
}
