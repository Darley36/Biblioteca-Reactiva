package co.com.sofka.biblioteca.reactive.routers;

import co.com.sofka.biblioteca.reactive.model.RecursoDTO;
import co.com.sofka.biblioteca.reactive.usecases.ListRecursoUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.BodyInserter;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.*;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class ListRecursoRouter {

    @Bean
    public RouterFunction<ServerResponse> getAllRecursos(ListRecursoUseCase listRecursoUseCase){
        return route(GET("/getAllRecursos"),
                request -> ServerResponse.ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(BodyInserters.fromPublisher(listRecursoUseCase.get(), RecursoDTO.class)));
    }
}
