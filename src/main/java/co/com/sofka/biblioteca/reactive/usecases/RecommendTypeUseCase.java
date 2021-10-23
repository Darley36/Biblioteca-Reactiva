package co.com.sofka.biblioteca.reactive.usecases;

import co.com.sofka.biblioteca.reactive.model.RecursoDTO;
import co.com.sofka.biblioteca.reactive.repositories.RepositorioRecurso;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import reactor.core.publisher.Flux;

import java.util.Objects;
import java.util.function.Function;

@Service
@Validated
public class RecommendTypeUseCase implements Function<String, Flux<RecursoDTO>> {

    private final RepositorioRecurso repositorioRecurso;
    private final MapperUtils mapperUtils;

    public RecommendTypeUseCase(RepositorioRecurso repositorioRecurso, MapperUtils mapperUtils) {
        this.repositorioRecurso = repositorioRecurso;
        this.mapperUtils = mapperUtils;
    }
    @Override
    public Flux<RecursoDTO> apply(String id){
        Objects.requireNonNull(id,"El id es requerido");
        return repositorioRecurso.findByType(id)
                .map(recurso -> mapperUtils.mapRecursoToDTO().apply(recurso));
    }
}
