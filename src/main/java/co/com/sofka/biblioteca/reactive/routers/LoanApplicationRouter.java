package co.com.sofka.biblioteca.reactive.routers;

import co.com.sofka.biblioteca.reactive.usecases.LoanApplicationUseCase;
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
public class LoanApplicationRouter {

    @Bean
    public RouterFunction<ServerResponse> prestamoRecurso(LoanApplicationUseCase loanApplicationUseCase){
        return route(GET("/get/prestamo/{id}").and(accept(MediaType.APPLICATION_JSON)),
                request -> ServerResponse.ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(BodyInserters.fromPublisher(loanApplicationUseCase
                                .apply(request.pathVariable("id")), String.class)));
    }
}
