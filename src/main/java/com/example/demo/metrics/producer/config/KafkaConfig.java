package com.example.demo.metrics.producer.config;

import com.example.demo.metrics.producer.dto.User;
import org.apache.kafka.clients.admin.NewTopic;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaOperations;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.listener.CommonErrorHandler;
import org.springframework.kafka.listener.DeadLetterPublishingRecoverer;
import org.springframework.kafka.listener.DefaultErrorHandler;
import org.springframework.kafka.support.converter.RecordMessageConverter;
import org.springframework.kafka.support.converter.StringJsonMessageConverter;
import org.springframework.util.backoff.FixedBackOff;


@Configuration
public class KafkaConfig {

    @Bean
    public NewTopic topic(){
        return new NewTopic("topic1", 1, (short) 1);
    }

    @Bean
    public NewTopic dlt(){
        return new NewTopic("topic1.DLT", 1, (short) 1);
    }

    @Bean
    public NewTopic err(){
        return new NewTopic("error.topic", 1, (short) 1);
    }

    @Bean
    public RecordMessageConverter converter(){
        return new StringJsonMessageConverter();
    }

    @Bean
    public CommonErrorHandler errorHandler(KafkaTemplate<Object, Object> kafkaTemplate){
        return new DefaultErrorHandler(new DeadLetterPublishingRecoverer(kafkaTemplate),
                new FixedBackOff(1000L, 2));
    }

}
