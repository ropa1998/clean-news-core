import com.gargoylesoftware.htmlunit.WebClient;
import implementations.CleanNewsEngine;
import implementations.factory.RSSMediumScrapperFactory;
import implementations.factory.Trends24ScrapperFactory;
import implementations.factory.WebClientFactory;
import implementations.flusher.SoutFlusher;
import interfaces.*;

import java.util.HashSet;
import java.util.Set;

public class Main {

    public static void main(String[] args) {
        Set<TrendScrapper> trendScrappers = new HashSet<>();
        Set<MediumScrapper> mediumScrappers = new HashSet<>();

        WebClientFactory webClientFactory = new WebClientFactory();
        WebClient webClient = webClientFactory.getBasicWebClient();

        MediumScrapperFactory mediumScrapperFactory = new RSSMediumScrapperFactory(webClient);
        mediumScrappers.add(mediumScrapperFactory.getPagina12Scrapper());

        TrendScrapperFactory trendScrapperFactory = new Trends24ScrapperFactory(webClient);
        trendScrappers.add(trendScrapperFactory.getArgentinaScrapper());

        CleanNewsEngine cleanNewsEngine = new CleanNewsEngine(mediumScrappers, trendScrappers);
        cleanNewsEngine.run();

        CleanNewsResult cleanNewsResult = cleanNewsEngine.getResult();

        Flusher flusher = new SoutFlusher();
        flusher.flush(cleanNewsResult);
    }

}
