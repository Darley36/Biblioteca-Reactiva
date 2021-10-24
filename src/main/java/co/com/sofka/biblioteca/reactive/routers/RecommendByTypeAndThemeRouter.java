package co.com.sofka.biblioteca.reactive.routers;

import co.com.sofka.biblioteca.reactive.model.RecursoDTO;
import co.com.sofka.biblioteca.reactive.usecases.RecommendByTypeAndThemeUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class RecommendByTypeAndThemeRouter {
    @Bean
    public RouterFunction<ServerResponse> getRecursosPorTipoAndTema(RecommendByTypeAndThemeUseCase recommendByTypeAndThemeUseCase){
        return route(GET("/getportipoytema/{tipo}/{tema}").and(accept(MediaType.APPLICATION_JSON)),
                request -> ServerResponse.ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(BodyInserters.fromPublisher(recommendByTypeAndThemeUseCase
                                .get(request.pathVariable("tipo"), request.pathVariable("tema")), RecursoDTO.class)));
    }
}
