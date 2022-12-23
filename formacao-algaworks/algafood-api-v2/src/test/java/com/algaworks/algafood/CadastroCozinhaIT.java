package com.algaworks.algafood;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.TestPropertySource;

import com.algaworks.algafood.domain.model.Cozinha;
import com.algaworks.algafood.domain.repository.CozinhaRepository;
import com.algaworks.algafood.util.DatabaseCleaner;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

//@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@TestPropertySource("/application-test.properties")
public class CadastroCozinhaIT {

	@Autowired
	private static DatabaseCleaner databaseCleaner;

	@Autowired
	private static CozinhaRepository cozinhaRepository;

	@BeforeAll
	public static void setUp() {
		RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
		RestAssured.port = 8080;
		RestAssured.basePath = "/cozinhas";

		databaseCleaner.clearTables();
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
	public void deveConter2Cozinhas_QuandoConsultarCozinhas() {
		RestAssured.given()
				.accept(ContentType.JSON)
				.when()
				.get()
				.then()
				.body("", Matchers.hasSize(2));
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

	private static void prepararDados() {
		Cozinha cozinha1 = new Cozinha();
		cozinha1.setNome("Tailandesa");
		cozinhaRepository.save(cozinha1);

		Cozinha cozinha2 = new Cozinha();
		cozinha1.setNome("Americana");
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
