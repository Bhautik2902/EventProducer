package com.livevote.eventproducer.events;

import com.livevote.eventproducer.dto.PollOptionDto;
import lombok.Data;

import java.util.List;

@Data
public class PollCreatedEvent extends BaseEvent {

    private String poll_id;
    private String question;
    private List<PollOptionDto> options;
    private String createdBy;

    private long durationMin;

    private long createdAt;

    public PollCreatedEvent(String poll_id, String question, List<String> options, String createdBy, long durationMin, long createdAt) {
        this.poll_id = poll_id;
        this.question = question;
        this.options = options.stream().map(PollOptionDto::new).toList();
        this.createdBy = createdBy;
        this.durationMin = durationMin;
        this.createdAt = createdAt;
    }
}
