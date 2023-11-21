package com.example.demo.controller;

import java.util.ArrayList;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.demo.service.MyService;

import io.swagger.v3.oas.annotations.tags.Tag;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@RestController
@RequestMapping("/api")
@Tag(name = "open-api")
public class MyController {

    private static Logger log = LoggerFactory.getLogger(MyController.class);

    @Autowired
    private MyService myService;

    @GetMapping(value = "/webclient/{sleep}/jump/{jump}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Flux<Object> executar(@PathVariable("sleep") int sleep, @PathVariable("jump") int jump) {
        
        Thread currentThread = Thread.currentThread();

        var resultados = new ArrayList<Mono<Object>>();
        for (int i = 0; i < jump; i++) {
            var a = myService.executar(sleep);
            resultados.add(a);
        }

        log.info("### Retorno da requisição {}",  currentThread.getName());
        return Flux.merge(resultados);
    }


    @GetMapping(value = "/mono", produces = MediaType.APPLICATION_JSON_VALUE)
    public Mono<String> executarMono() {
        return Mono.just(UUID.randomUUID().toString());
    }

}

