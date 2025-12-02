package com.livevote.eventproducer.dto;

import lombok.Data;

import java.util.List;

@Data
public class CreatePollRequestDto {
    private String question;
    private List<String> options;
    private String createdBy;
    private long durationMin;
}

