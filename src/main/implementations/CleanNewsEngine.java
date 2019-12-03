package implementations;

import interfaces.Article;
import interfaces.MediumScrapper;
import interfaces.Trend;
import interfaces.TrendScrapper;

import java.util.Set;

public class CleanNewsEngine implements Runnable {

    private final Set<MediumScrapper> mediumScrapperSet;
    private final Set<TrendScrapper> trendScrapperSet;
    private interfaces.CleanNewsResult cleanNewsResult;

    public CleanNewsEngine(Set<MediumScrapper> mediumScrapperSet, Set<TrendScrapper> trendScrapperSet) {
        this.mediumScrapperSet = mediumScrapperSet;
        this.trendScrapperSet = trendScrapperSet;
        this.cleanNewsResult = new CleanNewsResult();
    }


    @Override
    public void run() {

        for (TrendScrapper trendScrapper : trendScrapperSet) {
            trendScrapper.run();
        }

        for (MediumScrapper mediumScrapper : this.mediumScrapperSet) {
            mediumScrapper.run();
            for (Article article : mediumScrapper.getArticles()) {
                for (TrendScrapper trendScrapper : trendScrapperSet) {
                    for (Trend trend : trendScrapper.getTrends()) {
                        if (article.getTitle().contains(trend.getName())) {
                            cleanNewsResult.add(trend, article);
                        }
                    }
                }
            }
        }


    }


    public interfaces.CleanNewsResult getResult() {
        return cleanNewsResult;
    }
}
