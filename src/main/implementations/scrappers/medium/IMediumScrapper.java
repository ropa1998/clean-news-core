package implementations.scrappers.medium;

import implementations.core.article.IArticle;
import implementations.IRunnable;

import java.util.Set;

public interface IMediumScrapper extends IRunnable {
    Set<IArticle> getArticles();
}
