package com.example.prog4;

import org.flywaydb.core.Flyway;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class FlywayConfiguration {
    @Bean(initMethod = "migrate")
    public Flyway flywayCnaps(@Qualifier("cnapsDataSource") DataSource dataSource) {
        return configureFlyway(dataSource, "classpath:db/migration/cnaps");
    }

    @Bean(initMethod = "migrate")
    public Flyway flywayEmployee(@Qualifier("employeeDataSource") DataSource dataSource) {
        return configureFlyway(dataSource, "classpath:db/migration/employee");
    }

    private Flyway configureFlyway(DataSource dataSource, String locations) {
        return Flyway.configure()
                .dataSource(dataSource)
                .locations(locations)
                .load();
    }
}
