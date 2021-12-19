package com.mastercard.axondashboard.model;

import lombok.Data;

@Data
public class Event {
    private EventHeader header;
    private String payload;
}
