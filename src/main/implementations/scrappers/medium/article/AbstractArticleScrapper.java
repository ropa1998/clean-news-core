package implementations.scrappers.medium.article;

import implementations.scrappers.AbstractScrapper;
import com.gargoylesoftware.htmlunit.WebClient;

public abstract class AbstractArticleScrapper extends AbstractScrapper implements IArticleScrapper {

    public AbstractArticleScrapper(WebClient webClient) {
        super(webClient);
    }

}
