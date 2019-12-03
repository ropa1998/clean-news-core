package implementations.core.cleanNewsResult;

import implementations.core.article.IArticle;
import implementations.core.trend.ITrend;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CleanNewsResult implements ICleanNewsResult {

    private Map<ITrend, List<IArticle>> trendListMap;

    public CleanNewsResult() {
        trendListMap = new HashMap<>();
    }

    public void add(ITrend trend, IArticle article) {
        if (!trendListMap.containsKey(trend)) {
            List<IArticle> articles = new ArrayList<>();
            articles.add(article);
            trendListMap.put(trend, articles);
        } else {
            List<IArticle> articles = trendListMap.get(trend);
            articles.add(article);
            trendListMap.put(trend, articles);
        }
    }

    @Override
    public Map<ITrend, List<IArticle>> getMap() {
        return trendListMap;
    }
}
