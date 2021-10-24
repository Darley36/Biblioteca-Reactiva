package co.com.sofka.biblioteca.reactive.routers;

import co.com.sofka.biblioteca.reactive.collections.Recurso;
import co.com.sofka.biblioteca.reactive.repositories.RepositorioRecurso;
import co.com.sofka.biblioteca.reactive.usecases.DeleteRecursoUseCase;
import co.com.sofka.biblioteca.reactive.usecases.GetRecursoUseCase;
import co.com.sofka.biblioteca.reactive.usecases.MapperUtils;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Mono;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@WebFluxTest
@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {GetRecursoRouter.class, GetRecursoUseCase.class, MapperUtils.class})
class GetRecursoRouterTest {

    @MockBean
    private RepositorioRecurso repositorioRecurso;

    @Autowired
    private WebTestClient webTestClient;


    @Test
    void listRecursoRouter() {

        var recurso = new Recurso();
        recurso.setId("xxx");
        recurso.setName("las aventuras");
        recurso.setAvailable(true);
        recurso.setDate(LocalDate.parse("2020-10-19"));
        recurso.setType("Libro");
        recurso.setThematic("Terror");
        recurso.setQuantityAvailable(2);
        recurso.setQuantityBorrowed(2);

        Mono<Recurso> mono = Mono.just(recurso);
        when(repositorioRecurso.findById("xxx")).thenReturn(mono);
        webTestClient.get()
                .uri("/get/xxx")
                .exchange()
                .expectStatus().isOk()
                .expectBody(Recurso.class)
                .value(userResponse -> {
                    Assertions.assertThat(userResponse.getId()).isEqualTo(recurso.getId());
                    Assertions.assertThat(userResponse.getName()).isEqualTo(recurso.getName());
                    Assertions.assertThat(userResponse.getDate()).isEqualTo(recurso.getDate());
                    Assertions.assertThat(userResponse.getType()).isEqualTo(recurso.getType());
                    Assertions.assertThat(userResponse.getThematic()).isEqualTo(recurso.getThematic());
                });
    }
}