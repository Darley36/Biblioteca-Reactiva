package co.com.sofka.biblioteca.reactive.usecases;

import co.com.sofka.biblioteca.reactive.collections.Recurso;
import co.com.sofka.biblioteca.reactive.repositories.RepositorioRecurso;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.SpyBean;
import reactor.core.publisher.Flux;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class RecommendTypeUseCaseTest {

    @MockBean
    private RepositorioRecurso repositorioRecurso;
    @SpyBean
    private RecommendTypeUseCase recommendTypeUseCase;

    @Test
    public void RecommendType() {
        var recurso =new Recurso();
        recurso.setId("xxx");
        recurso.setName("las aventuras");
        recurso.setAvailable(false);
        recurso.setDate(LocalDate.parse("2020-10-19"));
        recurso.setType("Libro");
        recurso.setThematic("Terror");
        recurso.setQuantityAvailable(2);
        recurso.setQuantityBorrowed(2);

        Mockito.when(repositorioRecurso.findByType(Mockito.any(String.class))).thenReturn(Flux.just(recurso));
        var respuesta = recommendTypeUseCase.apply("Libro");
        Assertions.assertEquals(respuesta.blockFirst().getName(), "las aventuras");
    }
}