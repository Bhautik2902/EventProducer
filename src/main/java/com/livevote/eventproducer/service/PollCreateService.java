package com.livevote.eventproducer.service;

import com.livevote.eventproducer.Enum.EventType;
import com.livevote.eventproducer.Enum.KafkaTopic;
import com.livevote.eventproducer.dto.CreatePollRequestDto;
import com.livevote.eventproducer.events.BaseEvent;
import com.livevote.eventproducer.events.PollCreatedEvent;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class PollCreateService extends PollEventService<CreatePollRequestDto> {

    public PollCreateService(EventFactory eventFactory, KafkaEventProducer eventProducer) {
        super(eventFactory, eventProducer);
    }

    @Override
    public void create(CreatePollRequestDto eventDto) {
        PollCreatedEvent payload = new PollCreatedEvent(
                UUID.randomUUID().toString(),
                eventDto.getQuestion(),
                eventDto.getOptions(),
                eventDto.getCreatedBy(),
                eventDto.getDurationMin(),
                System.currentTimeMillis()
        );

        BaseEvent event = eventFactory.create(EventType.POLL_CREATED, payload);

        eventProducer.publishEvent(KafkaTopic.POLL_CREATED.topic, event);

    }
}
