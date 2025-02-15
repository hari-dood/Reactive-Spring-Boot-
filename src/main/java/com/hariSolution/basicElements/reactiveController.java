package com.hariSolution.basicElements;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import reactor.core.publisher.Mono;

@Controller
public class reactiveController {
    @GetMapping("/home")
    public Mono<String> home(){
        return Mono.just("home");
    }
}
