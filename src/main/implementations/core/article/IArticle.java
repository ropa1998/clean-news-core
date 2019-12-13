package implementations.core.article;

import implementations.core.medium.IMedium;
import implementations.core.trend.ITrend;

import java.time.LocalDateTime;
import java.util.Set;

/**
 * This is the interface to which all Articles must be able to answer to.
 */
public interface IArticle {

    String getTitle();

    String getBody();

    String getUrl();

    Set<ITrend> getTrends();

    IMedium getMedium();

    LocalDateTime getDate();
}
