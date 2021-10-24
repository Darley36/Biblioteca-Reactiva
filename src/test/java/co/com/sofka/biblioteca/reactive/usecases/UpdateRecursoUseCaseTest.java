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
import reactor.core.publisher.Mono;

import java.time.LocalDate;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringBootTest
class UpdateRecursoUseCaseTest {

    @MockBean
    private RepositorioRecurso repositorioRecurso;

    @SpyBean
    private UpdateRecursoUseCase updateRecursoUseCase;

    @Test
    void updateRecurso(){
        var recursoDTO = new RecursoDTO("xxx","las aventuras",true,
                LocalDate.parse("2020-10-19"), "Libro",
                "Terror",2,2 );

        var recurso =new Recurso();
        recurso.setId("xxx");
        recurso.setName("las aventuras");
        recurso.setAvailable(true);
        recurso.setDate(LocalDate.parse("2020-10-19"));
        recurso.setType("Libro");
        recurso.setThematic("Terror");
        recurso.setQuantityAvailable(2);
        recurso.setQuantityBorrowed(2);

        when(repositorioRecurso.save(Mockito.any(Recurso.class))).thenReturn(Mono.just(recurso));
        var result=updateRecursoUseCase.apply(recursoDTO);
        Assertions.assertEquals(Objects.requireNonNull(result.block().getId()),"xxx");
    }
}