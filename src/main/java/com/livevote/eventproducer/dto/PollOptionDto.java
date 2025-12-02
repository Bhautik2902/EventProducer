package com.livevote.eventproducer.dto;

import lombok.Data;
import java.util.UUID;

@Data
public class PollOptionDto {
    private String optionId;
    private String text;

    public PollOptionDto(String text) {
        this.optionId = UUID.randomUUID().toString();
        this.text = text;
    }
}
