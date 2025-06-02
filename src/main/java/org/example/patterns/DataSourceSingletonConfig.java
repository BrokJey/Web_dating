package org.example.patterns;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class DataSourceSingletonConfig {

    private static DataSource dataSource;

    @Bean
    public DataSource dataSource() {
        if (dataSource == null) {
            HikariDataSource ds = new HikariDataSource();
            ds.setJdbcUrl("jdbc:postgresql://localhost:5432/dating_app");
            ds.setUsername("postgres");
            ds.setPassword("postgres");
            dataSource = ds;
        }
        return dataSource;
    }
}
