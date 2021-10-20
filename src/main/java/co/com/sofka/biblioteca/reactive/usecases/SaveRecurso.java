package co.com.sofka.biblioteca.reactive.usecases;

import co.com.sofka.biblioteca.reactive.model.RecursoDTO;
import reactor.core.publisher.Mono;

import javax.validation.Valid;

@FunctionalInterface
public interface SaveRecurso {
    public Mono<String> apply(@Valid RecursoDTO recursoDTO);
}
