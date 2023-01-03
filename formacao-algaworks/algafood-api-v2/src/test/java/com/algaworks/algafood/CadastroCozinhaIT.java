package com.algaworks.algafood;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.jdbc.JdbcTestUtils;

import com.algaworks.algafood.domain.model.Cozinha;
import com.algaworks.algafood.domain.repository.CozinhaRepository;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

//@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@TestPropertySource("/application-test.properties")
@TestInstance(Lifecycle.PER_CLASS)
public class CadastroCozinhaIT {

	@Autowired
	private CozinhaRepository cozinhaRepository;

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@BeforeAll
	public void setUp() {
		RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
		RestAssured.port = 8080;
		RestAssured.basePath = "/cozinhas";

		JdbcTestUtils.deleteFromTables(jdbcTemplate, "cozinha");
		prepararDados();
	}

	@Test
	public void deveRetornarStatus200_QuandoConsultarCozinhas() {
		RestAssured.given()
				.accept(ContentType.JSON)
				.when()
				.get()
				.then()
				.statusCode(HttpStatus.OK.value());
	}

	@Test
	public void deverRetornarStatus201_QuandoCadastrarCozinha() {
		RestAssured.given()
				.body("{ \"nome\": \"Chinesa\" }")
				.contentType(ContentType.JSON)
				.accept(ContentType.JSON)
				.when()
				.post()
				.then()
				.statusCode(HttpStatus.CREATED.value());
	}

	@Test
	public void deveConter2Cozinhas_QuandoConsultarCozinhas() {
		RestAssured.given()
				.accept(ContentType.JSON)
				.when()
				.get()
				.then()
				.body("", Matchers.hasSize(2));
	}

	@Test
	public void deveRetornarRespostaEStatusCorretos_QuandoConsultarCozinhasExistente() {
		RestAssured.given()
				.pathParam("cozinhaId", 29)
				.accept(ContentType.JSON)
				.when()
				.get("/{cozinhaId}")
				.then()
				.statusCode(HttpStatus.OK.value())
				.body("nome", Matchers.equalTo("Americana"));
	}

	@Test
	public void deveRetornarStatus404_QuandoConsultarCozinhasInexistente() {
		RestAssured.given()
				.pathParam("cozinhaId", 127)
				.accept(ContentType.JSON)
				.when()
				.get("/{cozinhaId}")
				.then()
				.statusCode(HttpStatus.NOT_FOUND.value());
	}

	private void prepararDados() {
		Cozinha cozinha1 = new Cozinha();
		cozinha1.setNome("Tailandesa");
		cozinhaRepository.save(cozinha1);

		Cozinha cozinha2 = new Cozinha();
		cozinha2.setNome("Americana");
		cozinhaRepository.save(cozinha2);
	}

	// ------------------- Integration Tests -------------------

	// @Autowired
	// private CozinhaService cozinhaService;

	// @Test
	// @DisplayName("Testa se o cadastro da cozinha esta funcionando")
	// public void testarCadastroCozinhaComSucesso() {
	// // cenário
	// Cozinha novaCozinha = new Cozinha();
	// novaCozinha.setNome("Chinesa");

	// // ação
	// novaCozinha = cozinhaService.salvar(novaCozinha);

	// // validação
	// assertNotNull(novaCozinha);
	// assertNotNull(novaCozinha.getId());
	// }

	// @Test()
	// public void testarCadastrarCozinhaSemNome() {
	// Cozinha novaCozinha = new Cozinha();
	// novaCozinha.setNome(null);

	// TransactionSystemException erroEsperado =
	// Assertions.assertThrows(TransactionSystemException.class, () -> {
	// cozinhaService.salvar(novaCozinha);
	// });

	// assertNotNull(erroEsperado);
	// }

	// @Test
	// public void deveFalhar_QuandoExcluirCozinhaEmUso() {

	// EntidadeEmUsoException erroEsperado =
	// Assertions.assertThrows(EntidadeEmUsoException.class, () -> {
	// cozinhaService.remover(1L);
	// });

	// assertNotNull(erroEsperado);
	// }

	// @Test
	// public void deveFalhar_QuandoExcluirCozinhaInexistente() {

	// CozinhaNaoEncontradaException erroEsperado =
	// Assertions.assertThrows(CozinhaNaoEncontradaException.class, () -> {
	// cozinhaService.remover(100L);
	// });

	// assertNotNull(erroEsperado);
	// }

}
