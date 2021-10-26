package com.kata.rockwell.divisor;

import lombok.extern.slf4j.Slf4j;
import org.h2.tools.Server;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.sql.SQLException;

@Configuration
@ComponentScan
@Slf4j
@EnableAutoConfiguration
@EnableJpaRepositories
public class DivisorConfig {

    @Bean(initMethod = "start", destroyMethod = "stop")
    @Profile("h2servermode")
    public Server h2Server() throws SQLException {
        return Server.createTcpServer("-tcp", "-tcpAllowOthers", "-tcpPort", "9092");
    }
}
