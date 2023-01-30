package br.com.basico.model;

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
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "host_cd_id")
	private Long id;
	
	@Column(name = "host_tx_nome", nullable = false)
	private String nome;
	
	@Column(name = "host_tx_usuario", nullable = false)
	private String usuario;

	@Column(name = "host_tx_senha", nullable = false)
	private String senha;
}
