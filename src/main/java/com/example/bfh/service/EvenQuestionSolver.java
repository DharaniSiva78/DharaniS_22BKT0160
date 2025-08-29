package com.example.bfh.service;

import com.example.bfh.config.AppProperties;
import org.springframework.stereotype.Component;

@Component("evenSqlSolver")
public class EvenQuestionSolver implements SqlSolver {

    private final AppProperties props;

    public EvenQuestionSolver(AppProperties props) {
        this.props = props;
    }

    @Override
    public String solve(String questionLink) {
        // In this template we read the final SQL from configuration.
        // Replace bfh.solution.final-query in application.yml with your final SQL for Question 2.
        return props.getSolution().getFinalQuery();
    }
}
