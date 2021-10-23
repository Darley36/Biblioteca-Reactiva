package co.com.sofka.biblioteca.reactive.usecases;

import co.com.sofka.biblioteca.reactive.collections.Recurso;
import co.com.sofka.biblioteca.reactive.repositories.RepositorioRecurso;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import reactor.core.publisher.Mono;

import java.time.LocalDate;
import java.util.function.Function;

@Service
@Validated
public class ReturnRequestUseCase implements Function<String, Mono<String>> {

    private final RepositorioRecurso repositorioRecurso;

    public ReturnRequestUseCase(RepositorioRecurso repositorioRecurso) {
        this.repositorioRecurso = repositorioRecurso;
    }

    @Override
    public Mono<String> apply(String id){
        Mono<Recurso> mono = repositorioRecurso.findById(id);
        return mono.flatMap(recurso -> {
            if (!recurso.isAvailable()) {
                LocalDate date = LocalDate.of(9999, 12, 31);
                recurso.setDate(date);
                recurso.setAvailable(true);
                return repositorioRecurso.save(recurso)
                        .thenReturn("El recurso fue devuelto con exito");
            }
            return Mono.just("Error al devolver");
        });
    }
}
