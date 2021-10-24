package co.com.sofka.biblioteca.reactive.usecases;


import co.com.sofka.biblioteca.reactive.model.RecursoDTO;
import reactor.core.publisher.Flux;

@FunctionalInterface
public interface RecommendTypeAndTheme {
    Flux<RecursoDTO> get(String type, String thematic);
}
