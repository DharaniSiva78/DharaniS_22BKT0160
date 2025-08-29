package com.example.bfh.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SubmitRequest {

    @JsonProperty("finalQuery")
    private String finalQuery;

    public SubmitRequest() {}

    public SubmitRequest(String finalQuery) {
        this.finalQuery = finalQuery;
    }

    public String getFinalQuery() { return finalQuery; }
    public void setFinalQuery(String finalQuery) { this.finalQuery = finalQuery; }
}
