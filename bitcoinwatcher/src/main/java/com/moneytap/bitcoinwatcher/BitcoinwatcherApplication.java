package com.moneytap.bitcoinwatcher;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.scheduling.annotation.EnableScheduling;

import com.moneytap.bitcoinwatcher.util.BitCoinWatcherConstants;

@SpringBootApplication

@EnableScheduling
@EnableJpaRepositories
@PropertySource(value = "classpath:/application.properties")
public class BitcoinwatcherApplication {
	private final Logger log = LoggerFactory.getLogger(this.getClass());
	@Autowired
	Environment env;
	
	@Autowired
	DataSource dataSource;
	public static void main(String[] args) {
		SpringApplication.run(BitcoinwatcherApplication.class, args);
	}
	
	}
