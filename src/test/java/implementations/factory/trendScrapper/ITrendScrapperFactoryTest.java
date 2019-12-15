package implementations.factory.trendScrapper;

import com.gargoylesoftware.htmlunit.WebClient;
import implementations.factory.webclient.WebClientFactory;
import implementations.scrappers.trend.ITrendScrapper;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

class ITrendScrapperFactoryTest {

    private final WebClient webClient;

    public ITrendScrapperFactoryTest() {
        WebClientFactory webClientFactory = new WebClientFactory();
        this.webClient = webClientFactory.getBasicWebClient();
    }

    @Test
    public void SimpleTrendScrapperFactoryTest() {
        ITrendScrapperFactory trendScrapperFactory = new Trends24ScrapperFactory(webClient);
        ITrendScrapper trendScrapper = trendScrapperFactory.getArgentinaScrapper();
        trendScrapper.run();
        assertTrue(!trendScrapper.getTrends().isEmpty());
    }

}