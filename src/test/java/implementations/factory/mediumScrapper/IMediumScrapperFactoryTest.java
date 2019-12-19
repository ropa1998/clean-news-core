package implementations.factory.mediumScrapper;

import com.gargoylesoftware.htmlunit.WebClient;
import implementations.factory.webclient.WebClientFactory;
import implementations.scrappers.medium.IMediumScrapper;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
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
        IMediumScrapper pagina12Scrapper = mediumScrapperFactory.getPagina12Scrapper();
        pagina12Scrapper.run();
        assertFalse(pagina12Scrapper.getArticles().isEmpty());
        IMediumScrapper laNacionScrapper = mediumScrapperFactory.getLaNacionScrapper();
        laNacionScrapper.run();
        assertFalse(laNacionScrapper.getArticles().isEmpty());
        IMediumScrapper nytAmericasAmericas = mediumScrapperFactory.getNYTAmericasScrapper();
        nytAmericasAmericas.run();
        assertFalse(nytAmericasAmericas.getArticles().isEmpty());
    }
}