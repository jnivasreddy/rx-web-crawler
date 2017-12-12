package webcrawler.resource;

import webcrawler.dto.CrawlerDto;

import com.webcrawler.resource.SampleWebcrawlerResource;
import com.webcrawler.service.SampleWebcrawlerService;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;

import java.util.Set;

/**
 * Created by sjanga on 12/12/2017.
 */
public class SampleWebcrawlerResourceTest {

  @InjectMocks
  SampleWebcrawlerResource sampleWebcrawlerResource;


  @Test
  public void searchDomain() {

    CrawlerDto crawlerDto = new CrawlerDto("http://wiprodigital.com/");
    Set<String> links = sampleWebcrawlerResource.searchDomain(crawlerDto);
    assert links != null & !links.isEmpty();

  }

  @Before
  public void setUp() throws Exception {
    sampleWebcrawlerResource = new SampleWebcrawlerResource();
    sampleWebcrawlerResource.setSampleWebcrawlerService(new SampleWebcrawlerService());
  }
}
