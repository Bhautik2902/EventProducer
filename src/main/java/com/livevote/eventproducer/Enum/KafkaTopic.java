package com.livevote.eventproducer.Enum;

public enum KafkaTopic {
    POLL_CREATED("poll_created"),
    VOTE_CAST("vote_cast");

    public final String topic;

    KafkaTopic(String topic) {
        this.topic = topic;
    }
}
