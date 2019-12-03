package implementations.flusher;

import implementations.core.article.IArticle;
import implementations.core.cleanNewsResult.ICleanNewsResult;
import implementations.flusher.IFlusher;
import implementations.core.trend.ITrend;

import java.util.List;
import java.util.Map;

public abstract class AbstractFlusher implements IFlusher {

    @Override
    public void flush(ICleanNewsResult cleanNewsResult) {
        Map<ITrend, List<IArticle>> map = cleanNewsResult.getMap();
        for (ITrend trend : map.keySet()) {
            flush(trend);
            for (IArticle article : map.get(trend)) {
                flush(article);
            }
        }
    }
}
