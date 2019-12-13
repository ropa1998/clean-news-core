package implementations;

import com.gargoylesoftware.htmlunit.WebClient;
import implementations.core.cleanNewsResult.ICleanNewsResult;
import implementations.factory.mediumScrapper.IMediumScrapperFactory;
import implementations.factory.mediumScrapper.RSSMediumScrapperFactory;
import implementations.factory.trendScrapper.ITrendScrapperFactory;
import implementations.factory.trendScrapper.Trends24ScrapperFactory;
import implementations.factory.webclient.WebClientFactory;
import implementations.flusher.FileFlusher;
import implementations.flusher.IFlusher;
import implementations.scrappers.medium.IMediumScrapper;
import implementations.scrappers.trend.ITrendScrapper;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

class CleanNewsEngineTest {

    private final WebClient webClient;
    private final String testPath;

    public CleanNewsEngineTest() {
        WebClientFactory webClientFactory = new WebClientFactory();
        this.webClient = webClientFactory.getBasicWebClient();

        this.testPath = "src/test/results/mock/";
    }

    @Test
    public void CleanNewsEngineTest() {
        Set<IMediumScrapper> mediumScrappers = new HashSet<>();
        Set<ITrendScrapper> trendScrappers = new HashSet<>();

        ITrendScrapperFactory trendScrapperFactory = new Trends24ScrapperFactory(webClient);
        trendScrappers.add(trendScrapperFactory.getArgentinaScrapper());

        IMediumScrapperFactory mediumScrapperFactory = new RSSMediumScrapperFactory(webClient);
        mediumScrappers.add(mediumScrapperFactory.getPagina12Scrapper());

        CleanNewsEngine cleanNewsEngine = new CleanNewsEngine(mediumScrappers, trendScrappers);
        cleanNewsEngine.run();

        ICleanNewsResult cleanNewsResult = cleanNewsEngine.getResult();

        IFlusher flusher = new FileFlusher(testPath + "cleanNewsEngineTestResult.txt");
        flusher.flush(cleanNewsResult);


    }

}