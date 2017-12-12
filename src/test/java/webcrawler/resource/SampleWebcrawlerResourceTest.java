package webcrawler.resource;

import com.webcrawler.dto.CrawlerDto;

import com.webcrawler.dto.CrawlerResponse;
import com.webcrawler.resource.SampleWebcrawlerResource;
import com.webcrawler.service.SampleWebcrawlerService;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;

import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by sjanga on 12/12/2017.
 */
public class SampleWebcrawlerResourceTest {

  @InjectMocks
  SampleWebcrawlerResource sampleWebcrawlerResource;


  @Test
  public void searchDomain() {

    CrawlerDto crawlerDto = new CrawlerDto("http://wiprodigital.com/");
    CrawlerResponse crawlerResponse = sampleWebcrawlerResource.searchDomain(crawlerDto);
    assert crawlerResponse.getCrawlers() != null && !crawlerResponse.getCrawlers().keySet().isEmpty();

  }

  @Before
  public void setUp() throws Exception {
    sampleWebcrawlerResource = new SampleWebcrawlerResource();
    sampleWebcrawlerResource.setSampleWebcrawlerService(new SampleWebcrawlerService());
  }
}
