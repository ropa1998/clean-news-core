package implementations.core.article;

import implementations.core.medium.IMedium;
import implementations.core.trend.ITrend;

import java.time.LocalDateTime;
import java.util.Set;

/**
 * This is the interface to which all Articles must be able to answer to.
 */
public interface IArticle {

    /**
     * @return The title of the Article
     */
    String getTitle();

    /**
     * @return The body of the Article
     */
    String getBody();

    /**
     * @return The url of the Article
     */
    String getUrl();

    /**
     * @return The trends related to the specific article
     */
    Set<ITrend> getTrends();

    /**
     * @return The IMedium from where the Article was scrapped from
     */
    IMedium getMedium();

    /**
     * @return The date and time on which the Article was scrapped.
     */
    LocalDateTime getDate();
}
