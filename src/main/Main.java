import com.gargoylesoftware.htmlunit.WebClient;
import implementations.CleanNewsEngine;
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

import java.util.HashSet;
import java.util.Set;

public class Main {

    public static void main(String[] args) {
        Set<ITrendScrapper> trendScrappers = new HashSet<>();
        Set<IMediumScrapper> mediumScrappers = new HashSet<>();

        WebClientFactory webClientFactory = new WebClientFactory();
        WebClient webClient = webClientFactory.getBasicWebClient();

        IMediumScrapperFactory mediumScrapperFactory = new RSSMediumScrapperFactory(webClient);
        mediumScrappers.add(mediumScrapperFactory.getPagina12Scrapper());

        ITrendScrapperFactory trendScrapperFactory = new Trends24ScrapperFactory(webClient);
        trendScrappers.add(trendScrapperFactory.getArgentinaScrapper());

        CleanNewsEngine cleanNewsEngine = new CleanNewsEngine(mediumScrappers, trendScrappers);
        cleanNewsEngine.run();

        ICleanNewsResult cleanNewsResult = cleanNewsEngine.getResult();

        IFlusher flusher = new FileFlusher("src/main/resources/results/result.txt");
        flusher.flush(cleanNewsResult);
    }

}
