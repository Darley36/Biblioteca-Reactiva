package co.com.sofka.biblioteca.reactive.usecases;

import co.com.sofka.biblioteca.reactive.model.RecursoDTO;
import co.com.sofka.biblioteca.reactive.repositories.RepositorioRecurso;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import reactor.core.publisher.Mono;

import java.util.Objects;

@Service
@Validated
public class UpdateRecursoUseCase implements SaveRecurso{

    private final RepositorioRecurso repositorioRecurso;
    private final MapperUtils mapperUtils;

    public UpdateRecursoUseCase(RepositorioRecurso repositorioRecurso, MapperUtils mapperUtils) {
        this.repositorioRecurso = repositorioRecurso;
        this.mapperUtils = mapperUtils;
    }

    @Override
    public Mono<RecursoDTO> apply(RecursoDTO recursoDTO){
        Objects.requireNonNull(recursoDTO.getId(), "El id no puede ser nulo");
        return repositorioRecurso.save(mapperUtils.mapperTorecurso().apply(recursoDTO))
                .map(recurso -> mapperUtils.mapRecursoToDTO().apply(recurso));
    }
}
