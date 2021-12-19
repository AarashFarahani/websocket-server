package com.mastercard.axondashboard.utils;

import lombok.extern.log4j.Log4j2;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Log4j2
@Component
public class AxonMessageSocketHandler extends TextWebSocketHandler {
    private List<WebSocketSession> sessions = new ArrayList<>();

    @Override
    public void handleTextMessage(WebSocketSession session, TextMessage message)
            throws IOException {
        for (int i = 0; i < 10; i++) {
            session.sendMessage(new TextMessage("Message " + i));
        }
    }

    @Scheduled(fixedRate = 5000, initialDelay = 1000)
    public void fixedRateSch() {
        log.info("Scheduled");
        for (WebSocketSession session : sessions) {
            try {
                this.handleTextMessage(session, new TextMessage("This is a test"));
            } catch (IOException e) {
                log.error(e);
            }
        }
    }

    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        this.sessions.add(session);
    }

    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
        this.sessions.remove(session);
    }
}
