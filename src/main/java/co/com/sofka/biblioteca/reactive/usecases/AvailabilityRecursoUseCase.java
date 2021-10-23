package co.com.sofka.biblioteca.reactive.usecases;

import co.com.sofka.biblioteca.reactive.collections.Recurso;
import co.com.sofka.biblioteca.reactive.repositories.RepositorioRecurso;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import reactor.core.publisher.Mono;

import java.util.function.Function;

@Service
@Validated
public class AvailabilityRecursoUseCase implements Function<String, Mono<String>> {
    private final RepositorioRecurso repositorioRecurso;

    @Autowired
    public AvailabilityRecursoUseCase(RepositorioRecurso repositorioRecurso) {
        this.repositorioRecurso = repositorioRecurso;
    }

    @Override
    public Mono<String> apply(String id){
        Mono<Recurso> mono = repositorioRecurso.findById(id);
        return mono.map(recurso -> recurso.isAvailable()? "El recurso se encuentra disponible":
                "Recurso no diponible, fecha de prestamo : "+recurso.getDate());
    }

}
