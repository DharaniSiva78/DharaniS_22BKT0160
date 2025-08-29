package com.example.bfh.service;

public interface SqlSolver {
    /**
     * Produce the final SQL query string to submit.
     * @param questionLink Link to the Google Drive PDF of the assigned question.
     * @return final SQL query
     */
    String solve(String questionLink);
}
