package implementations.core.article;

import implementations.core.medium.IMedium;
import implementations.core.trend.ITrend;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

public abstract class AbstractArticle implements IArticle {

    private final String title;
    private final String body;
    private final IMedium medium;
    private final String url;
    private final HashSet<ITrend> trends;
    private final LocalDateTime date;

    public AbstractArticle(String title, String body, String url, IMedium medium) {
        this.title = title;
        this.body = body;
        this.url = url;
        this.medium = medium;
        this.trends = new HashSet<>();
        this.date = LocalDateTime.now();
    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public String getBody() {
        return body;
    }

    @Override
    public String getUrl() {
        return url;
    }

    @Override
    public Set<ITrend> getTrends() {
        return trends;
    }

    @Override
    public LocalDateTime getDate() {
        return date;
    }

    @Override
    public IMedium getMedium() {
        return medium;
    }
}
