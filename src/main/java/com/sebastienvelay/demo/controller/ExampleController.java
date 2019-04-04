package com.sebastienvelay.demo.controller;

import com.sebastienvelay.demo.service.ExampleService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.server.ServerWebExchange;
import org.thymeleaf.spring5.context.webflux.ReactiveDataDriverContextVariable;
import reactor.core.publisher.Mono;

@Controller
public class ExampleController {

    private ExampleService exampleService;

    public ExampleController(ExampleService exampleService) {
        this.exampleService = exampleService;
    }

    @GetMapping
    public Mono<String> coucou(Model model, ServerWebExchange exchange) {

        model.addAttribute("maList", new ReactiveDataDriverContextVariable(exampleService.getContent(), 1));

        return Mono.just("index");
    }


}
