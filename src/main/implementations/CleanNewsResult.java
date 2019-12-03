package implementations;

import interfaces.Article;
import interfaces.Trend;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CleanNewsResult implements interfaces.CleanNewsResult {

    private Map<Trend, List<Article>> trendListMap;

    public CleanNewsResult() {
        trendListMap = new HashMap<>();
    }

    public void add(Trend trend, Article article) {
        if (!trendListMap.containsKey(trend)) {
            List<Article> articles = new ArrayList<>();
            articles.add(article);
            trendListMap.put(trend, articles);
        } else {
            List<Article> articles = trendListMap.get(trend);
            articles.add(article);
            trendListMap.put(trend, articles);
        }
    }

    @Override
    public Map<Trend, List<Article>> getMap() {
        return trendListMap;
    }
}
