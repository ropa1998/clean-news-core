package implementations.flusher;

import implementations.core.article.IArticle;
import implementations.core.cleanNewsResult.ICleanNewsResult;
import implementations.core.trend.ITrend;

public interface IFlusher {

    /**
     * @param cleanNewsResult
     * Flushes a cleanNewsResult.
     */
    void flush(ICleanNewsResult cleanNewsResult);

    /**
     * @param article
     * Flushes an article.
     */
    void flush(IArticle article);

    /**
     * @param trend
     * Flushes a trend.
     */
    void flush(ITrend trend);

}
