package com.example.demo.metrics.producer.util;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
@Slf4j
public class ExceptionGeneration {

    public Exception generateError() {
        int numErr = new Random().nextInt(100)+1;
        return new RuntimeException("Ошибка: " + numErr);
    }
}
