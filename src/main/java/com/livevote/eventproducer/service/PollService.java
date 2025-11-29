package com.livevote.eventproducer.service;

import com.livevote.eventproducer.Enum.EventType;
import com.livevote.eventproducer.Enum.KafkaTopic;
import com.livevote.eventproducer.dto.CreatePollRequest;
import com.livevote.eventproducer.dto.VoteRequest;
import com.livevote.eventproducer.service.events.BaseEvent;
import com.livevote.eventproducer.service.events.payload.PollCreatedPayload;
import com.livevote.eventproducer.service.events.payload.VoteCastPayload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class PollService {

    @Autowired
    private EventFactory eventFactory;

    @Autowired
    private KafkaEventProducer eventProducer;

    public void createPoll(CreatePollRequest request) {

        PollCreatedPayload payload = new PollCreatedPayload(
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

    public void vote(VoteRequest request) {

        VoteCastPayload payload = new VoteCastPayload(
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

