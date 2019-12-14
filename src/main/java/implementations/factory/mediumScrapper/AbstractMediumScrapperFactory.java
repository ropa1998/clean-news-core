package implementations.factory.mediumScrapper;

import implementations.scrappers.AbstractScrapper;
import com.gargoylesoftware.htmlunit.WebClient;

public abstract class AbstractMediumScrapperFactory extends AbstractScrapper implements IMediumScrapperFactory {

    public AbstractMediumScrapperFactory(WebClient webClient) {
        super(webClient);
    }
}
