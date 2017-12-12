package com.webcrawler.service;

import rx.Observable;
import rx.schedulers.Schedulers;

import com.webcrawler.dto.CrawlerResponse;

import org.apache.log4j.Logger;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.HashMap;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

/**
 * Created by sjanga on 12/11/2017.
 */
@Component
public class SampleWebcrawlerService {

  private static final Logger log = Logger.getLogger(SampleWebcrawlerService.class);

  // this can be replaced with any caching layer like hazlecast
  private HashMap<String, ConcurrentHashMap<String, CrawlerResponse.PageCrawler>> inMemory;


  public SampleWebcrawlerService() {

    this.inMemory = new HashMap<>();
  }

  public CrawlerResponse search(String domain) {

    CrawlerResponse crawlerResponse = new CrawlerResponse();
    ConcurrentHashMap<String, CrawlerResponse.PageCrawler> domainLinks = null;
    if (inMemory.get(domain) != null) {
      domainLinks = inMemory.get(domain);
      crawlerResponse.setUrl(domain);
      crawlerResponse.setCrawlers(domainLinks);
      return crawlerResponse;
    }
    // updating empty hashmap
   domainLinks =
        new ConcurrentHashMap<>(16);
    inMemory.put(domain, domainLinks);

    Observable<String> links1 = processURL(domain, domain);
    links1.toBlocking().forEach(link -> {
    });
    crawlerResponse.setUrl(domain);
    crawlerResponse.setCrawlers(domainLinks);
    return crawlerResponse;
  }


  public Observable<String> processURL(String URL, String domain) {
    if (!inMemory.get(domain).containsKey(URL)) {

      inMemory.get(domain).put(URL, new CrawlerResponse.PageCrawler(URL));
      log.info("=====================" + URL);
      Document document;
      try {
        document = Jsoup.connect(URL).get();

        Elements linksOnPage = document.select("a[href]");
        Set<String> links = linksOnPage.stream()
            .map(element -> element.attr("abs:href"))
            .collect(Collectors.toSet());
        inMemory.get(domain).get(URL).setLinks(links);

        Elements mediaOnPage = document.select("[src]");
        Set<String> media = mediaOnPage.stream()
            .filter(page -> page.tagName().equals("img"))
            .map(element -> element.attr("abs:src"))
            .collect(Collectors.toSet());
        inMemory.get(domain).get(URL).setMedia(media);

        Set<String> filteredLinks = linksOnPage.stream()
            .filter( page -> page.attr("abs:href").startsWith(domain) && !inMemory.get(domain)
                .containsKey(page.attr("abs:href")))
            .map(element -> element.attr("abs:href"))
            .collect(Collectors.toSet());

        return rx.Observable.from(filteredLinks).observeOn(Schedulers.newThread()).flatMap(link -> {
          return processURL(link, domain);
        });

      } catch (IllegalArgumentException iae) {
        log.error("Error occurred while processing URL " + URL, iae);
      } catch (IOException e) {
        log.error("Error occurred while processing URL " + URL, e);
      }
    }
    return Observable.empty();
  }
}
