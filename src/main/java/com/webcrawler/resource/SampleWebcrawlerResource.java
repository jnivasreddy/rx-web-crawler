package com.webcrawler.resource;


import webcrawler.dto.CrawlerDto;

import com.webcrawler.service.SampleWebcrawlerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

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
  public Set<String> searchDomain(@RequestBody CrawlerDto crawlerDto) {

    return sampleWebcrawlerService.search(crawlerDto.getDomain());
  }

  public void setSampleWebcrawlerService(SampleWebcrawlerService sampleWebcrawlerService) {
    this.sampleWebcrawlerService = sampleWebcrawlerService;
  }
}
