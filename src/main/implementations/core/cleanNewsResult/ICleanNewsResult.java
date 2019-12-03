package implementations.core.cleanNewsResult;

import implementations.core.article.IArticle;
import implementations.core.trend.ITrend;

import java.util.List;
import java.util.Map;

public interface ICleanNewsResult {

    Map<ITrend, List<IArticle>> getMap();

    void add(ITrend trend, IArticle article);

}
