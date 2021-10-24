package co.com.sofka.biblioteca.reactive.usecases;

import co.com.sofka.biblioteca.reactive.model.RecursoDTO;
import co.com.sofka.biblioteca.reactive.repositories.RepositorioRecurso;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import reactor.core.publisher.Flux;

import java.util.Objects;

@Service
@Validated
public class RecommendByTypeAndThemeUseCase implements RecommendTypeAndTheme {
    private final RepositorioRecurso repositorioRecurso;
    private final MapperUtils mapperUtils;

    public RecommendByTypeAndThemeUseCase(RepositorioRecurso repositorioRecurso, MapperUtils mapperUtils) {
        this.repositorioRecurso = repositorioRecurso;
        this.mapperUtils = mapperUtils;
    }

    @Override
    public Flux<RecursoDTO> get(String tipo, String tema){
        Objects.requireNonNull(tipo,"El tipo es requerido");
        Objects.requireNonNull(tema,"El tema es requerido");
        return repositorioRecurso.findAllByTypeAndThematic(tipo, tema).map(recurso -> mapperUtils.mapRecursoToDTO().apply(recurso));

    }
}


