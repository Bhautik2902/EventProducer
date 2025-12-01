package com.livevote.eventproducer.service.events.payload;

import lombok.Data;
import java.util.UUID;

@Data
public class PollOptionPayload {
    private String optionId;
    private String text;

    public PollOptionPayload(String text) {
        this.optionId = UUID.randomUUID().toString();
        this.text = text;
    }
}
