package co.com.sofka.biblioteca.reactive.routers;

import co.com.sofka.biblioteca.reactive.usecases.LoanApplicationUseCase;
import co.com.sofka.biblioteca.reactive.usecases.ReturnRequestUseCase;
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
public class ReturnRequestRouter {
    @Bean
    public RouterFunction<ServerResponse> devolucionRecurso(ReturnRequestUseCase returnRequestUseCase){
        return route(GET("/get/devolucion/{id}").and(accept(MediaType.APPLICATION_JSON)),
                request -> ServerResponse.ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(BodyInserters.fromPublisher(returnRequestUseCase
                                .apply(request.pathVariable("id")), String.class)));
    }
}
