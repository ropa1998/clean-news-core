package implementations.scrappers;

import com.gargoylesoftware.htmlunit.WebClient;

public abstract class AbstractScrapper {

    protected final WebClient webClient;

    public AbstractScrapper(WebClient webClient) {
        this.webClient = webClient;
    }
}
