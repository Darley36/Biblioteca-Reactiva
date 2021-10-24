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

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class AvailabilityRecursoUseCaseTest {

    @MockBean
    private RepositorioRecurso repositorioRecurso;
    @SpyBean
    private AvailabilityRecursoUseCase availabilityRecursoUseCase;

    @Test
    public void get() {

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

        Mockito.when(repositorioRecurso.findById(Mockito.any(String.class))).thenReturn(Mono.just(recurso));

        var respuesta = availabilityRecursoUseCase.apply("xxx");
        Assertions.assertEquals(respuesta.block().toString(), "El recurso se encuentra disponible");
    }
}