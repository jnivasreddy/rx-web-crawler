package com.webcrawler.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by sjanga on 12/12/2017.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CrawlerResponse {

  private String url;
  ConcurrentHashMap<String, PageCrawler> crawlers;


  @Data
  @NoArgsConstructor
  @AllArgsConstructor
  public static class PageCrawler {

    private String url;
    private Set<String> links;
    private Set<String> media;

    public PageCrawler(String url) {
      this.url = url;
    }

  }
}
