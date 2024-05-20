package com.example.demo.metrics.producer.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Random;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Класс пользователя")
public class User {
    @Schema(description = "Имя пользователя", example = "Вадим")
    private String firstName;
    @Schema(description = "Фамилия пользователя", example = "Давыдов")
    private String lastName;
    @Schema(description = "Возраст пользователя", example = "45")
    private Integer age;

}
