package implementations.core.article;

import implementations.core.medium.IMedium;
import implementations.core.trend.ITrend;

import java.time.LocalDateTime;
import java.util.Set;

public interface IArticle {

    String getTitle();

    String getBody();

    String getUrl();

    Set<ITrend> getTrends();

    IMedium getMedium();

    LocalDateTime getDate();
}
