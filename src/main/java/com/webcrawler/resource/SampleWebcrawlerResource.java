package com.webcrawler.resource;


import com.webcrawler.dto.CrawlerDto;
import com.webcrawler.dto.CrawlerResponse;
import com.webcrawler.service.SampleWebcrawlerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by sjanga on 12/11/2017.
 */
@RestController
@RequestMapping("/crawler")
public class SampleWebcrawlerResource {

  @Autowired
  private SampleWebcrawlerService sampleWebcrawlerService;

  @RequestMapping(value = "/search", produces = "application/json",
      consumes = "application/json", method = RequestMethod.POST)
  public CrawlerResponse searchDomain(@RequestBody CrawlerDto crawlerDto) {

    return sampleWebcrawlerService.search(crawlerDto.getDomain());
  }

  public void setSampleWebcrawlerService(SampleWebcrawlerService sampleWebcrawlerService) {
    this.sampleWebcrawlerService = sampleWebcrawlerService;
  }
}
