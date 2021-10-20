package co.com.sofka.biblioteca.reactive.usecases;

import co.com.sofka.biblioteca.reactive.collections.Recurso;
import co.com.sofka.biblioteca.reactive.model.RecursoDTO;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class MapperUtils {
    public Function<RecursoDTO, Recurso> mapperTorecurso(String id) {
        return updateRecurso -> {
            var recurso = new Recurso();
            recurso.setId(id);
            recurso.setName(updateRecurso.getName());
            recurso.setAvailable(updateRecurso.isAvailable());
            recurso.setDate(updateRecurso.getDate());
            recurso.setType(updateRecurso.getType());
            recurso.setThematic(updateRecurso.getThematic());
            recurso.setQuantityAvailable(updateRecurso.getQuantityAvailable());
            recurso.setQuantityBorrowed(updateRecurso.getQuantityBorrowed());
            return recurso;
        };
    }

    public Function<Recurso, RecursoDTO> mapRecursoToDTO() {
        return entity -> new RecursoDTO(
                entity.getId(),
                entity.getName(),
                entity.isAvailable(),
                entity.getDate(),
                entity.getType(),
                entity.getThematic(),
                entity.getQuantityAvailable(),
                entity.getQuantityBorrowed()
        );
    }
}
