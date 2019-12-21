package implementations.scrappers.medium;

import implementations.IRunnable;
import implementations.core.article.IArticle;

import java.util.Set;

public interface IMediumScrapper extends IRunnable {
    Set<IArticle> getArticles();
}
