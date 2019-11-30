package asbtract;

import interfaces.Medium;
import interfaces.Trend;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

public abstract class Article implements interfaces.Article {

    private final String title;
    private final String body;
    private final Medium medium;
    private final String url;
    private final HashSet<Trend> trends;
    private final LocalDateTime date;

    public Article(String title, String body, String url, interfaces.Medium medium) {
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
    public Set<Trend> getTrends() {
        return trends;
    }

    @Override
    public LocalDateTime getDate() {
        return date;
    }

    @Override
    public Medium getMedium() {
        return medium;
    }
}
