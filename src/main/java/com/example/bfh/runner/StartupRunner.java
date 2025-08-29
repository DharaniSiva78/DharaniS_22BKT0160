package com.example.bfh.runner;

import com.example.bfh.service.SqlSolver;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
public class StartupRunner implements CommandLineRunner {

    private final SqlSolver sqlSolver;
    private final JdbcTemplate jdbcTemplate;

    public StartupRunner(@Qualifier("evenSqlSolver") SqlSolver sqlSolver, JdbcTemplate jdbcTemplate) {
        this.sqlSolver = sqlSolver;
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void run(String... args) throws Exception {
        // Generate SQL
        String question = "SELECT * FROM employee WHERE id % 2 = 0";
        String sql = sqlSolver.solve(question);

        System.out.println("Generated SQL Query: \n" + sql);

        // ✅ Run SQL on H2 DB
        List<Map<String, Object>> results = jdbcTemplate.queryForList(sql);

        // ✅ Print results
        for (Map<String, Object> row : results) {
            System.out.println(row);
        }
    }
}
