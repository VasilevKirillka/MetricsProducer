package com.example.demo.metrics.producer.controller;

import com.example.demo.metrics.producer.dto.ErrorDto;
import com.example.demo.metrics.producer.dto.User;
import com.example.demo.metrics.producer.service.ProducerService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.*;


@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
@Tag(name = "Управление отправкой данных из Producer", description = "Методы отправки данных из Producer в Consumer")
public class ProducerController {

    private final ProducerService service;

    @Operation(summary = "Отправка User в Consumer",
            description = "Метод отправляет пользователей с помощью Kafka в Consumer")
    @PostMapping("/send")
    public void sendUsers(){
        service.sendUsers();
    }
    @Operation(summary = "Отправка User в Consumer",
            description = "Метод создает и отправляет пользователя с помощью Kafka в Consumer")
    @PostMapping("/sendUser")
    public void sentUser(@RequestBody User user){
        service.sendUser(user);
    }

    @Operation(summary = "Отправка ErrorDto в Consumer",
            description = "Тестовый метод, который после запуска приложения" +
                    "каждые 15 секунд отправляет ошибки с помощью Kafka в Consumer")
    @Scheduled(fixedRate = 15000)
    public void sendError() {
        service.sendError();
    }

}
