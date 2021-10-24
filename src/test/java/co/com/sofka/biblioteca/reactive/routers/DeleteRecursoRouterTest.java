package co.com.sofka.biblioteca.reactive.routers;

import co.com.sofka.biblioteca.reactive.collections.Recurso;
import co.com.sofka.biblioteca.reactive.model.RecursoDTO;
import co.com.sofka.biblioteca.reactive.repositories.RepositorioRecurso;
import co.com.sofka.biblioteca.reactive.usecases.CreateRecursoUseCase;
import co.com.sofka.biblioteca.reactive.usecases.DeleteRecursoUseCase;
import co.com.sofka.biblioteca.reactive.usecases.MapperUtils;
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

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@WebFluxTest
@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {DeleteRecursoRouter.class, DeleteRecursoUseCase.class, MapperUtils.class})
class DeleteRecursoRouterTest {

    @MockBean
    private RepositorioRecurso repositorioRecurso;

    @Autowired
    private WebTestClient webTestClient;


    @Test
    void crearRecursoRouter() {

        var recurso = new Recurso();
        recurso.setId("xxx");

        when(repositorioRecurso.deleteById(recurso.getId())).thenReturn(Mono.empty());

        webTestClient.delete()
                .uri("/eliminar/xxx")
                .exchange()
                .expectStatus().isAccepted()
                .expectBody().isEmpty();
    }
}