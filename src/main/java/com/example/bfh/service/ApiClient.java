package com.example.bfh.service;

import com.example.bfh.dto.GenerateWebhookRequest;
import com.example.bfh.dto.GenerateWebhookResponse;
import com.example.bfh.dto.SubmitRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class ApiClient {

    private static final Logger log = LoggerFactory.getLogger(ApiClient.class);
    private final WebClient webClient;

    public ApiClient(WebClient.Builder builder) {
        this.webClient = builder
                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .build();
    }

    public GenerateWebhookResponse generateWebhook(String baseUrl, GenerateWebhookRequest request) {
        String url = baseUrl + "/hiring/generateWebhook/JAVA";
        log.info("POST {}", url);
        return webClient.post()
                .uri(url)
                .bodyValue(request)
                .retrieve()
                .bodyToMono(GenerateWebhookResponse.class)
                .doOnNext(res -> log.info("Received webhook: {}, token present: {}", res.getWebhook(), res.getAccessToken() != null))
                .block();
    }

    public String submitSolution(String submitUrl, String accessToken, SubmitRequest body) {
        log.info("POST {} with Authorization token", submitUrl);
        return webClient.post()
                .uri(submitUrl)
                .header(HttpHeaders.AUTHORIZATION, accessToken) // per question paper: JWT without 'Bearer '
                .contentType(MediaType.APPLICATION_JSON)
                .body(Mono.just(body), SubmitRequest.class)
                .retrieve()
                .bodyToMono(String.class)
                .block();
    }
}
