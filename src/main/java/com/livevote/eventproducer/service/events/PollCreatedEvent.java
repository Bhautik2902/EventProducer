package com.livevote.eventproducer.service.events;

import com.livevote.eventproducer.service.events.payload.PollCreatedPayload;
import lombok.Data;

@Data
public class PollCreatedEvent extends BaseEvent {
    private PollCreatedPayload payload;
    public PollCreatedEvent(PollCreatedPayload payload) {
        this.payload = payload;
    }
}
