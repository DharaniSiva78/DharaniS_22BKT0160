package com.example.bfh.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "bfh")
public class AppProperties {

    private String baseUrl;
    private String name;
    private String regNo;
    private String email;
    private final Solution solution = new Solution();

    public static class Solution {
        private String finalQuery = "SELECT 1;";

        public String getFinalQuery() {
            return finalQuery;
        }

        public void setFinalQuery(String finalQuery) {
            this.finalQuery = finalQuery;
        }
    }

    public String getBaseUrl() { return baseUrl; }
    public void setBaseUrl(String baseUrl) { this.baseUrl = baseUrl; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getRegNo() { return regNo; }
    public void setRegNo(String regNo) { this.regNo = regNo; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public Solution getSolution() { return solution; }
}
