import com.gargoylesoftware.htmlunit.WebClient;
import implementations.CleanNewsEngine;
import implementations.cli.FlusherSolver;
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
import implementations.scrappers.medium.IMediumScrapper;
import implementations.scrappers.trend.ITrendScrapper;

import java.util.HashSet;
import java.util.Set;

public class Main {

    private static final String flag = "-";
    final private static String trendKeyword = "trends";
    final private static String mediumKeyword = "media";
    final private static String flusherKeyword = "flusher";

    public static void main(String[] args) {
        Set<ITrendScrapper> trendScrappers = new HashSet<>();
        Set<IMediumScrapper> mediumScrappers = new HashSet<>();
        Set<IFlusher> flushers = new HashSet<>();

        WebClientFactory webClientFactory = new WebClientFactory();
        WebClient webClient = webClientFactory.getBasicWebClient();

        IMediumScrapperFactory mediumScrapperFactory = new RSSMediumScrapperFactory(webClient);
        ITrendScrapperFactory trendScrapperFactory = new Trends24ScrapperFactory(webClient);

        IArgsSolver trendsScrapperArgsSolver = new TrendsScrapperSolver(trendScrappers, trendScrapperFactory, flag, trendKeyword);
        IArgsSolver mediumScrapperArgsSolver = new MediumScrapperSolver(mediumScrappers, mediumScrapperFactory, flag, mediumKeyword);
        IArgsSolver flusherArgsSolver = new FlusherSolver(flushers, flag, flusherKeyword);

        trendsScrapperArgsSolver.solve(args);
        mediumScrapperArgsSolver.solve(args);
        flusherArgsSolver.solve(args);

        CleanNewsEngine cleanNewsEngine = new CleanNewsEngine(mediumScrappers, trendScrappers);
        cleanNewsEngine.run();

        ICleanNewsResult cleanNewsResult = cleanNewsEngine.getResult();

        for (IFlusher flusher : flushers) {
            flusher.flush(cleanNewsResult);
        }
    }

}
