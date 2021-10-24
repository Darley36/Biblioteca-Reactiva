package co.com.sofka.biblioteca.reactive.routers;

import co.com.sofka.biblioteca.reactive.collections.Recurso;
import co.com.sofka.biblioteca.reactive.model.RecursoDTO;
import co.com.sofka.biblioteca.reactive.repositories.RepositorioRecurso;
import co.com.sofka.biblioteca.reactive.usecases.LoanApplicationUseCase;
import co.com.sofka.biblioteca.reactive.usecases.MapperUtils;
import co.com.sofka.biblioteca.reactive.usecases.UpdateRecursoUseCase;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Mono;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@WebFluxTest
@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {LoanApplicationRouter.class, LoanApplicationUseCase.class, MapperUtils.class})
class LoanApplicationRouterTest {

    @MockBean
    private RepositorioRecurso repositorioRecurso;

    @Autowired
    private WebTestClient webTestClient;


    @Test
    void loanApplicationRouter() {

        var recurso =new Recurso();
        recurso.setId("xxx");
        recurso.setName("las aventuras");
        recurso.setAvailable(false);
        recurso.setDate(LocalDate.parse("2020-10-19"));
        recurso.setType("Libro");
        recurso.setThematic("Terror");
        recurso.setQuantityAvailable(2);
        recurso.setQuantityBorrowed(2);


        var recursoDTO = new RecursoDTO("xxx","las aventuras",true,
                LocalDate.parse("2020-10-19"), "Libro",
                "Terror",2,2 );
        Mono<Recurso> mono = Mono.just(recurso);

        when(repositorioRecurso.findById(recurso.getId())).thenReturn(mono);

        webTestClient.get()
                .uri("/get/prestamo/xxx")
                .accept(MediaType.APPLICATION_JSON)
                .exchange()
                .expectStatus().isOk()
                .expectBody(String.class)
                .value( userResponse -> {
                    Assertions.assertThat(userResponse).isEqualTo("Recurso no se encuentra disponible");
                });
    }
}