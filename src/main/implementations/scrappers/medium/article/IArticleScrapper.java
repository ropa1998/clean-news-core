package implementations.scrappers.medium.article;

import implementations.core.article.IArticle;
import implementations.core.title.ITitle;

public interface IArticleScrapper {
    IArticle scrap(ITitle title);
}
