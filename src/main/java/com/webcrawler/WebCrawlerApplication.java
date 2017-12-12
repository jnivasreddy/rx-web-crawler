package com.webcrawler;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Created by sjanga on 12/11/2017.
 */
@SpringBootApplication
@ComponentScan("com.webcrawler")
public class WebCrawlerApplication {

  public static void main(String[] args) {
    SpringApplication.run(WebCrawlerApplication.class, args);
  }
}
