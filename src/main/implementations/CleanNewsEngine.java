package implementations;

import implementations.core.cleanNewsResult.CleanNewsResult;
import implementations.core.article.IArticle;
import implementations.core.cleanNewsResult.ICleanNewsResult;
import implementations.core.trend.ITrend;
import implementations.scrappers.trend.ITrendScrapper;
import implementations.scrappers.medium.IMediumScrapper;

import java.lang.Runnable;
import java.util.Set;

public class CleanNewsEngine implements Runnable {

    private final Set<IMediumScrapper> mediumScrapperSet;
    private final Set<ITrendScrapper> trendScrapperSet;
    private ICleanNewsResult cleanNewsResult;

    public CleanNewsEngine(Set<IMediumScrapper> mediumScrapperSet, Set<ITrendScrapper> trendScrapperSet) {
        this.mediumScrapperSet = mediumScrapperSet;
        this.trendScrapperSet = trendScrapperSet;
        this.cleanNewsResult = new CleanNewsResult();
    }


    @Override
    public void run() {

        for (ITrendScrapper trendScrapper : trendScrapperSet) {
            trendScrapper.run();
        }

        for (IMediumScrapper mediumScrapper : this.mediumScrapperSet) {
            mediumScrapper.run();
            for (IArticle article : mediumScrapper.getArticles()) {
                for (ITrendScrapper trendScrapper : trendScrapperSet) {
                    for (ITrend trend : trendScrapper.getTrends()) {
                        if (article.getTitle().contains(trend.getName())) {
                            cleanNewsResult.add(trend, article);
                        }
                    }
                }
            }
        }


    }


    public ICleanNewsResult getResult() {
        return cleanNewsResult;
    }
}
