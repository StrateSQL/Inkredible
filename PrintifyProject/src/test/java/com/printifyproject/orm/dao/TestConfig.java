package com.printifyproject.orm.dao;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@ComponentScan(basePackages = "com.printifyproject")
@EnableJpaRepositories(basePackages = "com.printifyproject.orm.dao")
@EntityScan(basePackages = "com.printifyproject.orm.model")
public class TestConfig {

}
