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
public class GetRecursoUseCase implements Function<String, Mono<RecursoDTO>> {
    private final RepositorioRecurso repositorioRecurso;
    private final MapperUtils mapperUtils;

    public GetRecursoUseCase(RepositorioRecurso repositorioRecurso, MapperUtils mapperUtils) {
        this.repositorioRecurso = repositorioRecurso;
        this.mapperUtils = mapperUtils;
    }
    @Override
    public Mono<RecursoDTO> apply(String id){
        Objects.requireNonNull(id,"El id es requerido");
        return repositorioRecurso.findById(id)
                .map(recurso -> mapperUtils.mapRecursoToDTO().apply(recurso));
    }
}
