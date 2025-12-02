package com.livevote.eventproducer.dto;

import lombok.Data;

@Data
public class VoteCreateRequestDto {
    private String pollId;
    private String optionId;
    private String userId;
}

