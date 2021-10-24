package co.com.sofka.biblioteca.reactive.routers;

import co.com.sofka.biblioteca.reactive.model.RecursoDTO;
import co.com.sofka.biblioteca.reactive.usecases.CreateRecursoUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import java.util.function.Function;

import static org.springframework.web.reactive.function.server.RequestPredicates.POST;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class CreateRecursoRouter {
    @Bean
    public RouterFunction<ServerResponse> createRecurso(CreateRecursoUseCase createRecursoUseCase){
        Function<RecursoDTO, Mono<ServerResponse>> executor = resourceDTO -> createRecursoUseCase.apply(resourceDTO)
                .flatMap(result -> ServerResponse.ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .bodyValue(result));

        return route(
                POST("/crear").and(accept(MediaType.APPLICATION_JSON)),
                request -> request.bodyToMono(RecursoDTO.class).flatMap(executor)
        );

    }
}
