package com.example.bfh.service;

import org.springframework.stereotype.Component;

@Component("oddSqlSolver")
public class OddQuestionSolver implements SqlSolver {
    @Override
    public String solve(String questionLink) {
        // Not used for reg no 0160 (even). Kept for completeness.
        return "SELECT 1;";
    }
}
