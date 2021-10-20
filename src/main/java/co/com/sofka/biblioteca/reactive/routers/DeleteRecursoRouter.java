package co.com.sofka.biblioteca.reactive.routers;

import co.com.sofka.biblioteca.reactive.usecases.DeleteRecursoUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RouterFunctions.route;
import static org.springframework.web.reactive.function.server.RequestPredicates.*;

@Configuration
public class DeleteRecursoRouter {

    @Bean
    public RouterFunction<ServerResponse> deleteRecurso(DeleteRecursoUseCase deleteRecursoUseCase){
        return route( DELETE("/eliminar/{id}").and(accept(MediaType.APPLICATION_JSON)),
                request ->ServerResponse.accepted()
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(BodyInserters.fromPublisher(deleteRecursoUseCase.apply(request.pathVariable("id")),Void.class))

        );
    }
}
