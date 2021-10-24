package co.com.sofka.biblioteca.reactive.usecases;

import co.com.sofka.biblioteca.reactive.collections.Recurso;
import co.com.sofka.biblioteca.reactive.model.RecursoDTO;
import co.com.sofka.biblioteca.reactive.repositories.RepositorioRecurso;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.SpyBean;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@SpringBootTest
class ListRecursoUseCaseTest {

    @MockBean
    private RepositorioRecurso repositorioRecurso;
    @SpyBean
    private ListRecursoUseCase listRecursoUseCase;

    @Test
    public void getAll() {

        var recurso =new Recurso();
        recurso.setId("xxx");
        recurso.setName("las aventuras");
        recurso.setAvailable(true);
        recurso.setDate(LocalDate.parse("2020-10-19"));
        recurso.setType("Libro");
        recurso.setThematic("Terror");
        recurso.setQuantityAvailable(2);
        recurso.setQuantityBorrowed(2);

        when(repositorioRecurso.findAll()).thenReturn(Flux.just(recurso));

        StepVerifier.create(listRecursoUseCase.get())
                .expectNextMatches(recursoDTO -> {
                    assert recursoDTO.getId().equals("xxx");
                    assert recursoDTO.getName().equals("las aventuras");
                    assert recursoDTO.isAvailable() == true;
                    assert recursoDTO.getDate().equals(LocalDate.parse("2020-10-19"));
                    assert recursoDTO.getType().equals("Libro");
                    assert recursoDTO.getThematic().equals("Terror");
                    assert recursoDTO.getQuantityAvailable() == 2;
                    assert recursoDTO.getQuantityBorrowed() == 2;
                    return true;
                })
                .verifyComplete();
        verify(repositorioRecurso).findAll();
    }
}