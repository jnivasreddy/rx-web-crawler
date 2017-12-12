package webcrawler.dto;

/**
 * Created by sjanga on 12/11/2017.
 */
public class CrawlerDto {

  private String domain;

  public CrawlerDto() {

  }

  public CrawlerDto(String domain) {
    this.domain = domain;
  }

  public String getDomain() {
    return domain;
  }

  public void setDomain(String domain) {
    this.domain = domain;
  }
}
