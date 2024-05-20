package com.example.demo.metrics.producer.service;


import com.example.demo.metrics.producer.dto.ErrorDto;
import com.example.demo.metrics.producer.dto.User;
import com.example.demo.metrics.producer.util.ExceptionGeneration;
import com.example.demo.metrics.producer.util.UserParser;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class ProducerService {

    private final KafkaTemplate<Object, Object> template;
    private final UserParser userProducerService;

    private final ExceptionGeneration generation;


    public void sendUsers(){
        List<User> users=userProducerService.parseUsers();
        users.forEach(user ->{
            log.info("sendUsers: {}", user);
            template.send("topic1", user);
        });
    }
    
    public void sendUser(User user){
        log.info("sendUser: {}", user);
        template.send("topic1", user);
    }

    public void sendError(){
        var error=generation.generateError();
        ErrorDto newError=new ErrorDto();
        newError.setException(error);
        newError.setErrorTime(LocalDateTime.now());
        log.info("sendError: {}", newError);
        template.send("error.topic", newError);
    }
    
    
}
