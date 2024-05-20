package com.example.demo.metrics.producer.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "Класс ошибки")
public class ErrorDto {
    @Schema(description = "Описание ошибки")
    private Exception exception;
    @Schema(description = "Время возникновения ошибки", example = "2024-05-17T15:52:52.585409500")
    private LocalDateTime errorTime;
}
