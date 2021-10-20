package co.com.sofka.biblioteca.reactive.usecases;

import co.com.sofka.biblioteca.reactive.model.RecursoDTO;
import reactor.core.publisher.Mono;

import javax.validation.Valid;

@FunctionalInterface
public interface SaveRecurso {
    Mono<RecursoDTO> apply(@Valid RecursoDTO recursoDTO);
}
