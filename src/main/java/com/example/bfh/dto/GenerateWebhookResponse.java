package com.example.bfh.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class GenerateWebhookResponse {

    @JsonProperty("webhook")
    private String webhook;

    @JsonProperty("accessToken")
    private String accessToken;

    @JsonProperty("message")
    private String message;

    public String getWebhook() { return webhook; }
    public void setWebhook(String webhook) { this.webhook = webhook; }

    public String getAccessToken() { return accessToken; }
    public void setAccessToken(String accessToken) { this.accessToken = accessToken; }

    public String getMessage() { return message; }
    public void setMessage(String message) { this.message = message; }
}
