package co.com.sofka.biblioteca.reactive.usecases;

import co.com.sofka.biblioteca.reactive.collections.Recurso;
import co.com.sofka.biblioteca.reactive.model.RecursoDTO;
import co.com.sofka.biblioteca.reactive.repositories.RepositorioRecurso;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import reactor.core.publisher.Mono;

@Service
@Validated
public class CreateRecursoUseCase implements SaveRecurso {
    private final RepositorioRecurso repositorioRecurso;
    private final MapperUtils mapperUtils;

    @Autowired
    public CreateRecursoUseCase(RepositorioRecurso repositorioRecurso, MapperUtils mapperUtils) {
        this.repositorioRecurso = repositorioRecurso;
        this.mapperUtils = mapperUtils;
    }

    @Override
    public Mono<String> apply(RecursoDTO recursoDTO) {
        return repositorioRecurso.save(mapperUtils.mapperTorecurso(null)
                .apply(recursoDTO)).map(Recurso::getId);
    }
}
