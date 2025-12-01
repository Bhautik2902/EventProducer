package com.livevote.eventproducer.service;

import com.livevote.eventproducer.Enum.EventType;
import com.livevote.eventproducer.service.events.BaseEvent;
import com.livevote.eventproducer.service.events.PollCreatedEvent;
import com.livevote.eventproducer.service.events.VoteCastEvent;
import com.livevote.eventproducer.service.events.payload.PollCreatedPayload;
import com.livevote.eventproducer.service.events.payload.VoteCastPayload;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Component
public class EventFactory {

    private final Map<EventType, Function<Object, BaseEvent>> registry = new HashMap<>();

    public EventFactory() {
        registry.put(EventType.POLL_CREATED, payload -> new PollCreatedEvent((PollCreatedPayload) payload));
        registry.put(EventType.VOTE_CAST, payload -> new VoteCastEvent((VoteCastPayload) payload));
    }

    public BaseEvent create(EventType eventType, Object payload) {
        Function<Object, BaseEvent> creator = registry.get(eventType);
        if (creator == null) {
            throw new IllegalArgumentException("Unknown event type: " + eventType);
        }
        return creator.apply(payload);
    }

    public void register(EventType type, Function<Object, BaseEvent> creator) {
        registry.put(type, creator);
    }

}
