package com.example.bfh.model;

import jakarta.persistence.*;
import java.time.Instant;

@Entity
public class SqlSolution {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String regNo;
    private String questionType; // ODD or EVEN
    @Lob
    private String finalQuery;
    private Instant createdAt = Instant.now();

    public SqlSolution() {}

    public SqlSolution(String regNo, String questionType, String finalQuery) {
        this.regNo = regNo;
        this.questionType = questionType;
        this.finalQuery = finalQuery;
    }

    public Long getId() { return id; }
    public String getRegNo() { return regNo; }
    public String getQuestionType() { return questionType; }
    public String getFinalQuery() { return finalQuery; }
    public Instant getCreatedAt() { return createdAt; }

    public void setId(Long id) { this.id = id; }
    public void setRegNo(String regNo) { this.regNo = regNo; }
    public void setQuestionType(String questionType) { this.questionType = questionType; }
    public void setFinalQuery(String finalQuery) { this.finalQuery = finalQuery; }
    public void setCreatedAt(Instant createdAt) { this.createdAt = createdAt; }
}
