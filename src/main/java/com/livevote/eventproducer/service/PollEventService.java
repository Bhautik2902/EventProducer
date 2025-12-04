package com.livevote.eventproducer.service;

import lombok.Data;
import org.springframework.stereotype.Service;

@Service
@Data
public abstract class PollEventService<T> {
    final EventFactory eventFactory;
    final KafkaEventProducer eventProducer;

    public PollEventService(EventFactory eventFactory, KafkaEventProducer eventProducer) {
        this.eventFactory = eventFactory;
        this.eventProducer = eventProducer;
    }

    public abstract void create(T event);
}
