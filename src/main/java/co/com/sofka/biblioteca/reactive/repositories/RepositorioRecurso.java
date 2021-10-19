package co.com.sofka.biblioteca.reactive.repositories;

import co.com.sofka.biblioteca.reactive.collections.Recurso;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Flux;

public interface RepositorioRecurso extends ReactiveMongoRepository<Recurso, String> {
    Flux<Recurso> findByThematic(String thematic);
    Flux<Recurso> findByType( String type);
}
