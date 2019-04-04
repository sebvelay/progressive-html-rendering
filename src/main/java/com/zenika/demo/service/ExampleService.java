package com.zenika.demo.service;

import com.zenika.demo.data.Contents;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;

@Service
public class ExampleService {

    private Contents contents;

    public ExampleService(Contents contents) {
        this.contents = contents;
    }

    public Flux<Contents.Data> getContent() {

        return getFluxDatas()
                .flatMap(this::loadContentWithDelays);
    }

    private Mono<Contents.Data> loadContentWithDelays(Contents.Data data) {
        return Mono.just(data)
                .delayElement(Duration.ofMillis(data.getDelay()));
    }

    private Flux<Contents.Data> getFluxDatas() {
        return Flux.fromStream(
                contents.getData().stream());
    }
}
