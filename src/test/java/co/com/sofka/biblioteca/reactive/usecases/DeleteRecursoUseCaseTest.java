package co.com.sofka.biblioteca.reactive.usecases;

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

@SpringBootTest
class DeleteRecursoUseCaseTest {

    @SpyBean
    private DeleteRecursoUseCase deleteRecursoUseCase;

    @MockBean
    private RepositorioRecurso repositorioRecurso;

    @Test
    void EliminarRecurso(){
        var recursoDTO = new RecursoDTO("xxx","las aventuras",true, LocalDate.parse("2020-10-19"), "Libro",
                "Terror",2,2 );

        Mockito.when(repositorioRecurso.deleteById("xxx")).thenReturn(Mono.empty());

        var result = deleteRecursoUseCase.apply("xxx").block();
        Assertions.assertEquals(result,null);
    }
}