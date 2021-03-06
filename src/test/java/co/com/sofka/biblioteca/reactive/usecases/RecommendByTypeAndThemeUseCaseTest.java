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
import reactor.core.publisher.Mono;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class RecommendByTypeAndThemeUseCaseTest {
    @MockBean
    private RepositorioRecurso repositorioRecurso;
    @SpyBean
    private RecommendByTypeAndThemeUseCase recommendByTypeAndThemeUseCase;

    @Test
    public void Recommend() {
        var recurso =new Recurso();
        recurso.setId("xxx");
        recurso.setName("las aventuras");
        recurso.setAvailable(false);
        recurso.setDate(LocalDate.parse("2020-10-19"));
        recurso.setType("Libro");
        recurso.setThematic("Terror");
        recurso.setQuantityAvailable(2);
        recurso.setQuantityBorrowed(2);

        Mockito.when(repositorioRecurso.findAllByTypeAndThematic(Mockito.any(String.class),Mockito.any(String.class))).thenReturn(Flux.just(recurso));
        var respuesta = recommendByTypeAndThemeUseCase.get("Libro","Terror");
        Assertions.assertEquals(respuesta.blockFirst().getName(), "las aventuras");
    }
}