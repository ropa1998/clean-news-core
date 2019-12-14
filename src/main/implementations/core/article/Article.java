package implementations.core.article;

import implementations.core.medium.IMedium;

/**
 * A concrete Article
 */
public class Article extends AbstractArticle {
    public Article(String title, String body, String url, IMedium medium) {
        super(title, body, url, medium);
    }
}
