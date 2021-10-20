package co.com.sofka.biblioteca.reactive.usecases;

import co.com.sofka.biblioteca.reactive.model.RecursoDTO;
import co.com.sofka.biblioteca.reactive.repositories.RepositorioRecurso;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import reactor.core.publisher.Mono;

import java.util.Objects;
import java.util.function.Function;

@Service
@Validated
public class DeleteRecursoUseCase implements Function<String, Mono<Void>> {
    private final RepositorioRecurso repositorioRecurso;

    public DeleteRecursoUseCase(RepositorioRecurso repositorioRecurso) {
        this.repositorioRecurso = repositorioRecurso;
    }

    @Override
    public Mono<Void> apply(String id) {
        Objects.requireNonNull(id, "El id es requerido");
        return repositorioRecurso.deleteById(id);
    }
}
