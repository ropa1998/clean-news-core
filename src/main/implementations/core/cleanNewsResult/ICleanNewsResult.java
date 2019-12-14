package implementations.core.cleanNewsResult;

import implementations.core.article.IArticle;
import implementations.core.trend.ITrend;

import java.util.List;
import java.util.Map;

public interface ICleanNewsResult {
    /**
     * @return The map with the trends and all the articles related to the trends.
     */
    Map<ITrend, List<IArticle>> getMap();

    /**
     * Receives a trends and an article.
     * If the trend already exists in the trendListMap it just gets the list, adds the article and puts it back in the map
     * If the trend was not previously registered it creates a new list, adds the article and puts the relation of the trend and the list in the map.
     *
     * @param trend   The trend to which the article you are passing is related to
     * @param article The article you want to save
     */
    void add(ITrend trend, IArticle article);

}
