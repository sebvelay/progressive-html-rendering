package com.zenika.demo.data;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@ConfigurationProperties("contents")
@Getter
@Setter
public class Contents {

    private List<Data> data;

    @Getter
    @Setter
    public static class Data {

        private String id;
        private String content;
        private int delay;

    }
}
