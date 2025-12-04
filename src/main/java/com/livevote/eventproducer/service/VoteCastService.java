package com.livevote.eventproducer.service;

import com.livevote.eventproducer.Enum.EventType;
import com.livevote.eventproducer.Enum.KafkaTopic;
import com.livevote.eventproducer.dto.VoteCreateRequestDto;
import com.livevote.eventproducer.events.BaseEvent;
import com.livevote.eventproducer.events.VoteCastEvent;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class VoteCastService extends PollEventService<VoteCreateRequestDto>{

    public VoteCastService(EventFactory eventFactory, KafkaEventProducer eventProducer) {
        super(eventFactory, eventProducer);
    }

    @Override
    public void create(VoteCreateRequestDto eventDto) {
        VoteCastEvent payload = new VoteCastEvent(
                UUID.randomUUID().toString(),
                eventDto.getPollId(),
                eventDto.getOptionId(),
                eventDto.getUserId(),
                System.currentTimeMillis()
        );

        BaseEvent event = eventFactory.create(EventType.VOTE_CAST, payload);

        eventProducer.publishEvent(KafkaTopic.VOTE_CAST.topic, event);
    }
}
