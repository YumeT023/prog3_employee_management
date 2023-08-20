package com.example.prog4.config;

import javax.sql.DataSource;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
    entityManagerFactoryRef = "cnapsEntityManagerFactory",
    basePackages = {"com.example.prog4.repository.cnaps"},
    transactionManagerRef = "cnapsTransactionManager"
)
@RequiredArgsConstructor
public class CnapsPersistenceConf {
  private final Environment env;

  @Bean
  @ConfigurationProperties(prefix = "cnaps.datasource")
  public DataSource cnapsDataSource() {
    return DataSourceBuilder.create().build();
  }

  @Bean
  public LocalContainerEntityManagerFactoryBean cnapsEntityManagerFactory() {
    var entityManager = new LocalContainerEntityManagerFactoryBean();
    JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();

    entityManager.setDataSource(cnapsDataSource());
    entityManager.setJpaVendorAdapter(vendorAdapter);
    entityManager.setPackagesToScan("com.example.prog4.model.core.entity.cnaps");
//    entityManager.setJpaPropertyMap(Map.of(
//        "hibernate.hbm2ddl.auto", requireNonNull(env.getProperty("common.jpa.hibernate.ddl-auto")),
//        "hibernate.dialect", requireNonNull(env.getProperty("hibernate.dialect"))
//    ));

    return entityManager;
  }

  @Bean
  public PlatformTransactionManager cnapsTransactionManager() {
    var transactionManager = new JpaTransactionManager();
    transactionManager.setEntityManagerFactory(cnapsEntityManagerFactory().getObject());
    return transactionManager;
  }
}
