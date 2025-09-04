package dev.codersite.apifinance.config;

import dev.codersite.apifinance.service.TimeValueOfMoneyService;
import dev.codersite.apifinance.service.TimeValueOfMoneyServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApiBeansConfig {

  @Bean
  public TimeValueOfMoneyService timeValueOfMoneyService() {
    return new TimeValueOfMoneyServiceImpl();
  }
}
