package implementations;

import implementations.core.cleanNewsResult.CleanNewsResult;
import implementations.core.article.IArticle;
import implementations.core.cleanNewsResult.ICleanNewsResult;
import implementations.core.trend.ITrend;
import implementations.scrappers.trend.ITrendScrapper;
import implementations.scrappers.medium.IMediumScrapper;

import java.lang.Runnable;
import java.util.Set;

/**
 * The engine that combines the user configuration to create the CleanNewsResult
 */
public class CleanNewsEngine implements IRunnable {

    private final Set<IMediumScrapper> mediumScrapperSet;
    private final Set<ITrendScrapper> trendScrapperSet;
    private ICleanNewsResult cleanNewsResult;

    /**
     * @param mediumScrapperSet The set of mediums you want scrapped.
     * @param trendScrapperSet The set of trend regions you want scrapped
     * Both combined will later generate the CleanNewsResult
     */
    public CleanNewsEngine(Set<IMediumScrapper> mediumScrapperSet, Set<ITrendScrapper> trendScrapperSet) {
        this.mediumScrapperSet = mediumScrapperSet;
        this.trendScrapperSet = trendScrapperSet;
        this.cleanNewsResult = new CleanNewsResult();
    }


    /**
     * This method fires both the trends scrappers and the medium scrappers
     * It later crosses the information to generate the CleanNewsResult corresponding to this run.
     */
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


    /**
     * @return The populated CleanNewsResult
     */
    public ICleanNewsResult getResult() {
        return cleanNewsResult;
    }
}
