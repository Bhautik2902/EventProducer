package com.livevote.eventproducer.service;

import com.livevote.eventproducer.Enum.EventType;
import com.livevote.eventproducer.service.events.BaseEvent;
import com.livevote.eventproducer.service.events.PollCreatedEvent;
import com.livevote.eventproducer.service.events.VoteCastEvent;
import com.livevote.eventproducer.service.events.payload.PollCreatedPayload;
import com.livevote.eventproducer.service.events.payload.VoteCastPayload;
import org.springframework.stereotype.Component;

@Component
public class EventFactory {

    public BaseEvent create(EventType eventType, Object payload) {

        switch (eventType) {
            case POLL_CREATED:
                return new PollCreatedEvent((PollCreatedPayload) payload);

            case VOTE_CAST:
                return new VoteCastEvent((VoteCastPayload) payload);

            default:
                throw new IllegalArgumentException("Unknown event type: " + eventType);
        }
    }
}
