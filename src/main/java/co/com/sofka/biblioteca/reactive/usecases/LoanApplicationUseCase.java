package co.com.sofka.biblioteca.reactive.usecases;


import co.com.sofka.biblioteca.reactive.collections.Recurso;
import co.com.sofka.biblioteca.reactive.repositories.RepositorioRecurso;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import reactor.core.publisher.Mono;

import java.time.LocalDate;
import java.util.function.Function;

@Service
@Validated
public class LoanApplicationUseCase implements Function<String, Mono<String>> {

    private final RepositorioRecurso repositorioRecurso;

    @Autowired
    public LoanApplicationUseCase(RepositorioRecurso repositorioRecurso) {
        this.repositorioRecurso = repositorioRecurso;
    }

    @Override
    public Mono<String> apply(String id){
        Mono<Recurso> mono = repositorioRecurso.findById(id);
        return mono.flatMap(recurso -> {
            if (recurso.isAvailable()) {
                recurso.setDate(LocalDate.now());
                recurso.setAvailable(false);
                return repositorioRecurso.save(recurso)
                        .thenReturn("El recurso fue prestado con exito");
            }
            return Mono.just("Recurso no se encuentra disponible");
        });
    }
}
