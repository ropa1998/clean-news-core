package asbtract;

import interfaces.Article;
import interfaces.CleanNewsResult;
import interfaces.Trend;

import java.util.List;
import java.util.Map;

public abstract class Flusher implements interfaces.Flusher {

    @Override
    public void flush(CleanNewsResult cleanNewsResult) {
        Map<Trend, List<interfaces.Article>> map = cleanNewsResult.getMap();
        for (Trend trend : map.keySet()) {
            flush(trend);
            for (Article article : map.get(trend)) {
                flush(article);
            }
        }
    }
}
