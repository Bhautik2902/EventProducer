package com.livevote.eventproducer.service.events;

import com.livevote.eventproducer.service.events.payload.VoteCastPayload;
import lombok.Data;

@Data
public class VoteCastEvent extends BaseEvent{
    private VoteCastPayload payload;
    public VoteCastEvent(VoteCastPayload payload) {
        this.payload = payload;
    }
}
