package com.senla.springJpa;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@PropertySource({"classpath:database.properties"})

@EnableTransactionManagement
public class JpaConfiguration {
    @Value("${database.driverClassName}")
    private String driverClassName;
    @Value("${database.url}")
    private String databaseUrl;
    @Value("${database.username}")
    private String username;
    @Value("${database.password}")
    private String password;
    @Value("${hibernate.hbm2ddl.auto}")
    private String hibernateHbm2ddlAuto;
    @Value("${hibernate.show_sql:false}")
    private String showSql;
    @Value("${hibernate.dialect}")
    private String hibernateDialect;
    @Value("${hibernate.enable_lazy_load_no_trans}")
    private String hibernateLazyLOadTrans;
    @Value("${hibernate.use_jdbc_metadata_defaults}")
    private String hibernateTempUseJdbcMetadataDefaults;


    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSourse = new DriverManagerDataSource();
        dataSourse.setDriverClassName(driverClassName);
        dataSourse.setUrl(databaseUrl);
        dataSourse.setUsername(username);
        dataSourse.setPassword(password);
        return dataSourse;
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManager() {
        LocalContainerEntityManagerFactoryBean entityManager = new LocalContainerEntityManagerFactoryBean();
        entityManager.setDataSource(dataSource());
        entityManager.setPackagesToScan("com.senla.model");
        JpaVendorAdapter jpaVendorAdapter = new HibernateJpaVendorAdapter();
        entityManager.setJpaVendorAdapter(jpaVendorAdapter);
        entityManager.setJpaProperties(getJpaProperties());
        return entityManager;
    }
    @Bean
    public JpaTransactionManager transactionManager(EntityManagerFactory entityManagerFactory){
        JpaTransactionManager transactionManager=new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(entityManagerFactory);
        return transactionManager;
    }


    private Properties getJpaProperties() {
        Properties properties = new Properties();
        properties.setProperty("hibernate.hbm2ddl.auto", hibernateHbm2ddlAuto);
        properties.setProperty("hibernate.dialect", hibernateDialect);
        properties.setProperty("hibernate.show_sql", showSql);
        properties.setProperty("hibernate.enable_lazy_load_no_trans", hibernateLazyLOadTrans);
        properties.setProperty("hibernate.use_jdbc_metadata_defaults", hibernateTempUseJdbcMetadataDefaults);
        return properties;
    }




}
