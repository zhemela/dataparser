package com.example.dataparser.service;

import com.example.dataparser.dto.PostDto;
import com.example.dataparser.util.TwitterCollector;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import twitter4j.Status;

import java.util.LinkedList;
import java.util.List;

@Service
public class PostService {
    @Value("${kafka.topic.name}")
    private String topic;
    @Autowired
    TwitterCollector twitterCollector;

    private final KafkaTemplate<Long, PostDto> kafkaPostTemplate;
    private final ObjectMapper objectMapper;

    @Autowired
    public PostService(KafkaTemplate<Long, PostDto> kafkaPostTemplate, ObjectMapper objectMapper) {
        this.kafkaPostTemplate = kafkaPostTemplate;
        this.objectMapper = objectMapper;
    }

    public void postMessage(PostDto post) {
        kafkaPostTemplate.send(topic, post);
        List<Status> statuses = new LinkedList<>();
        statuses.stream().map(status -> new PostDto(status.getText(), status.getFavoriteCount()))
                .forEach(p -> kafkaPostTemplate.send(topic, post));
    }


}
