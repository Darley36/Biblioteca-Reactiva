package co.com.sofka.biblioteca.reactive.routers;

import co.com.sofka.biblioteca.reactive.collections.Recurso;
import co.com.sofka.biblioteca.reactive.model.RecursoDTO;
import co.com.sofka.biblioteca.reactive.repositories.RepositorioRecurso;
import co.com.sofka.biblioteca.reactive.usecases.ListRecursoUseCase;
import co.com.sofka.biblioteca.reactive.usecases.MapperUtils;
import co.com.sofka.biblioteca.reactive.usecases.UpdateRecursoUseCase;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Flux;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@WebFluxTest
@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {ListRecursoRouter.class, ListRecursoUseCase.class, MapperUtils.class})
class ListRecursoRouterTest {

    @MockBean
    private RepositorioRecurso repositorioRecurso;

    @Autowired
    private WebTestClient webTestClient;


    @Test
    void listRecursoRouter() {

        var recurso = new Recurso();
        recurso.setId("xxx");
        recurso.setName("las aventuras");
        recurso.setAvailable(false);
        recurso.setDate(LocalDate.parse("2020-10-19"));
        recurso.setType("Libro");
        recurso.setThematic("Terror");
        recurso.setQuantityAvailable(2);
        recurso.setQuantityBorrowed(2);

        when(repositorioRecurso.findAll()).thenReturn(Flux.just(recurso));

        webTestClient.get()
                .uri("/getAllRecursos")
                .exchange()
                .expectStatus().isOk()
                .expectBodyList(RecursoDTO.class)
                .value(userResponse -> {
                    Assertions.assertThat(userResponse.get(0).getId()).isEqualTo(recurso.getId());
                    Assertions.assertThat(userResponse.get(0).getName()).isEqualTo(recurso.getName());
                    Assertions.assertThat(userResponse.get(0).isAvailable()).isEqualTo(recurso.isAvailable());
                    Assertions.assertThat(userResponse.get(0).getDate()).isEqualTo(recurso.getDate());
                    Assertions.assertThat(userResponse.get(0).getThematic()).isEqualTo(recurso.getThematic());
                    Assertions.assertThat(userResponse.get(0).getType()).isEqualTo(recurso.getType());

                });

    }
}