package com.livevote.eventproducer.service.events.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
public class PollCreatedPayload {
    private String poll_id;
    private String question;
    private List<PollOptionPayload> options;
    private String createdBy;

    private long durationMin;

    private long createdAt;

    public PollCreatedPayload(String poll_id, String question, List<String> options, String createdBy, long durationMin, long createdAt) {
        this.poll_id = poll_id;
        this.question = question;
        this.options = options.stream().map(PollOptionPayload::new).toList();
        this.createdBy = createdBy;
        this.durationMin = durationMin;
        this.createdAt = createdAt;
    }

}

