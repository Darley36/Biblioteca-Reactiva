package co.com.sofka.biblioteca.reactive.usecases;

import co.com.sofka.biblioteca.reactive.model.RecursoDTO;
import co.com.sofka.biblioteca.reactive.repositories.RepositorioRecurso;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import reactor.core.publisher.Flux;

import java.util.function.Supplier;

@Service
@Validated
public class ListRecursoUseCase implements Supplier<Flux<RecursoDTO>> {
    private final RepositorioRecurso repositorioRecurso;
    private final MapperUtils mapperUtils;

    public ListRecursoUseCase(RepositorioRecurso repositorioRecurso, MapperUtils mapperUtils) {
        this.repositorioRecurso = repositorioRecurso;
        this.mapperUtils = mapperUtils;
    }

    @Override
    public Flux<RecursoDTO> get() {
        return repositorioRecurso.findAll()
                .map(resource -> mapperUtils.mapRecursoToDTO().apply(resource));
    }
}
