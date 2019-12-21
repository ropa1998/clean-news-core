package implementations.scrappers.medium.article;

import com.gargoylesoftware.htmlunit.WebClient;
import implementations.scrappers.AbstractScrapper;
import implementations.scrappers.medium.article.IArticleScrapper;

public abstract class AbstractArticleScrapper extends AbstractScrapper implements IArticleScrapper {

    public AbstractArticleScrapper(WebClient webClient) {
        super(webClient);
    }

}
