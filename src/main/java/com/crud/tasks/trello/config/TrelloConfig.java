package com.crud.tasks.trello.config;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Getter
@Component
public class TrelloConfig {


    private String trelloUsername;


    private String trelloApiEndpoint;


    private String trelloAppKey;


    private String trelloToken;

    public TrelloConfig(@Value("${trello.app.username}") String trelloUsername,
                        @Value("${trello.api.endpoint.prod}") String trelloApiEndpoint,
                        @Value("${trello.app.key}") String trelloAppKey,
                        @Value("${trello.app.token}") String trelloToken) {
        this.trelloUsername = trelloUsername;
        this.trelloApiEndpoint = trelloApiEndpoint;
        this.trelloAppKey = trelloAppKey;
        this.trelloToken = trelloToken;
    }
}
