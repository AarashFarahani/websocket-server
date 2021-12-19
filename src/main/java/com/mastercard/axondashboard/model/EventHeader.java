package com.mastercard.axondashboard.model;

import lombok.Data;

@Data
public class EventHeader {
    private String topic;
    private String packageName;
    private String name;
}
