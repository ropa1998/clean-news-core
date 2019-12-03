package implementations.flusher;

import implementations.core.article.IArticle;
import implementations.core.cleanNewsResult.ICleanNewsResult;
import implementations.core.trend.ITrend;

public interface IFlusher {

    void flush(ICleanNewsResult cleanNewsResult);

    void flush(IArticle article);

    void flush(ITrend trend);

}
