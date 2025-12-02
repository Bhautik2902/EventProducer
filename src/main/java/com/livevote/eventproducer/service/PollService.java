package com.livevote.eventproducer.service;

import com.livevote.eventproducer.Enum.EventType;
import com.livevote.eventproducer.Enum.KafkaTopic;
import com.livevote.eventproducer.dto.CreatePollRequestDto;
import com.livevote.eventproducer.dto.VoteCreateRequestDto;
import com.livevote.eventproducer.events.BaseEvent;
import com.livevote.eventproducer.events.PollCreatedEvent;
import com.livevote.eventproducer.events.VoteCastEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class PollService {

    @Autowired
    private EventFactory eventFactory;

    @Autowired
    private KafkaEventProducer eventProducer;

    public void createPoll(CreatePollRequestDto request) {

        PollCreatedEvent payload = new PollCreatedEvent(
                UUID.randomUUID().toString(),
                request.getQuestion(),
                request.getOptions(),
                request.getCreatedBy(),
                request.getDurationMin(),
                System.currentTimeMillis()
        );

        BaseEvent event = eventFactory.create(EventType.POLL_CREATED, payload);

        eventProducer.publishEvent(KafkaTopic.POLL_CREATED.topic, event);
    }

    public void vote(VoteCreateRequestDto request) {

        VoteCastEvent payload = new VoteCastEvent(
                UUID.randomUUID().toString(),
                request.getPollId(),
                request.getOptionId(),
                request.getUserId(),
                System.currentTimeMillis()
        );

        BaseEvent event = eventFactory.create(EventType.VOTE_CAST, payload);

        eventProducer.publishEvent(KafkaTopic.VOTE_CAST.topic, event);
    }
}

