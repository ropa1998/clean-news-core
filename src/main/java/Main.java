import com.gargoylesoftware.htmlunit.WebClient;
import implementations.CleanNewsEngine;
import implementations.cli.IArgsSolver;
import implementations.cli.MediumScrapperSolver;
import implementations.cli.TrendsScrapperSolver;
import implementations.core.cleanNewsResult.ICleanNewsResult;
import implementations.factory.mediumScrapper.IMediumScrapperFactory;
import implementations.factory.mediumScrapper.RSSMediumScrapperFactory;
import implementations.factory.trendScrapper.ITrendScrapperFactory;
import implementations.factory.trendScrapper.Trends24ScrapperFactory;
import implementations.factory.webclient.WebClientFactory;
import implementations.flusher.IFlusher;
import implementations.flusher.SoutFlusher;
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
        ITrendScrapperFactory trendScrapperFactory = new Trends24ScrapperFactory(webClient);

        IArgsSolver trendsScrapperArgsSolver = new TrendsScrapperSolver(trendScrappers, trendScrapperFactory);
        IArgsSolver mediumScrapperArgsSolver = new MediumScrapperSolver(mediumScrappers, mediumScrapperFactory);

        trendsScrapperArgsSolver.solve(args);
        mediumScrapperArgsSolver.solve(args);

        CleanNewsEngine cleanNewsEngine = new CleanNewsEngine(mediumScrappers, trendScrappers);
        cleanNewsEngine.run();

        ICleanNewsResult cleanNewsResult = cleanNewsEngine.getResult();

//        IFlusher flusher = new FileFlusher("src/main/resources/results/result.txt");
        IFlusher flusher = new SoutFlusher();
        flusher.flush(cleanNewsResult);
    }

}
