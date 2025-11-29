package com.livevote.eventproducer.service.events;

import java.time.Instant;

public class BaseEvent {
    private String eventId;
    private String eventType;
    private Instant timestamp;
}
