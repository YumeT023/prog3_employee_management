package com.example.prog4.config;

import java.util.Map;
import javax.sql.DataSource;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import static java.util.Objects.requireNonNull;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
    entityManagerFactoryRef = "managementEntityManagerFactory",
    basePackages = {"com.example.prog4.repository.management"},
    transactionManagerRef = "managementTransactionManager"
)
@RequiredArgsConstructor
public class ManagementPersistenceConf {
  private final Environment env;

  @Bean
  public DataSource managementDataSource() {
    var dataSource = new DriverManagerDataSource();
    dataSource.setDriverClassName(requireNonNull(env.getProperty("common.datasource.driver-class-name")));
    dataSource.setUrl(env.getProperty("management.datasource.url"));
    dataSource.setUsername(env.getProperty("management.datasource.username"));
    dataSource.setPassword(env.getProperty("management.datasource.password"));
    return dataSource;
  }

  @Bean
  public LocalContainerEntityManagerFactoryBean managementEntityManagerFactoryBean() {
    var entityManager = new LocalContainerEntityManagerFactoryBean();
    JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();

    entityManager.setDataSource(managementDataSource());
    entityManager.setJpaVendorAdapter(vendorAdapter);
    entityManager.setPackagesToScan("com.example.prog4.model.core.entity.management");
    entityManager.setJpaPropertyMap(Map.of(
        "hibernate.hbm2ddl.auto", requireNonNull(env.getProperty("common.jpa.hibernate.ddl-auto")),
        "hibernate.dialect", requireNonNull(env.getProperty("hibernate.dialect"))
    ));

    return entityManager;
  }

  @Bean
  public PlatformTransactionManager managementTransactionManager() {
    var transactionManager = new JpaTransactionManager();
    transactionManager.setEntityManagerFactory(managementEntityManagerFactoryBean().getObject());
    return transactionManager;
  }
}
