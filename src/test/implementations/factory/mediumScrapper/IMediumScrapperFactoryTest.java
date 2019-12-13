package implementations.factory.mediumScrapper;

import com.gargoylesoftware.htmlunit.WebClient;
import implementations.factory.webclient.WebClientFactory;
import implementations.scrappers.medium.IMediumScrapper;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

class IMediumScrapperFactoryTest {

    WebClient webClient;

    public IMediumScrapperFactoryTest() {
        WebClientFactory webClientFactory = new WebClientFactory();
        webClient = webClientFactory.getBasicWebClient();
    }

    @Test
    public void BasicMediumScrapperFactoryWorks() {
        IMediumScrapperFactory mediumScrapperFactory = new BasicMediumScrapperFactory(webClient);
        IMediumScrapper mediumScrapper = mediumScrapperFactory.getPagina12Scrapper();
        mediumScrapper.run();
        assertTrue(!mediumScrapper.getArticles().isEmpty());
    }

    @Test
    public void RSSMediumScrapperFactoryWorks() {
        IMediumScrapperFactory mediumScrapperFactory = new RSSMediumScrapperFactory(webClient);
        IMediumScrapper mediumScrapper = mediumScrapperFactory.getPagina12Scrapper();
        mediumScrapper.run();
        assertTrue(!mediumScrapper.getArticles().isEmpty());
    }
}