package implementations.factory.trendScrapper;


import com.gargoylesoftware.htmlunit.WebClient;

public abstract class AbstractTrendScrapperFactory implements ITrendScrapperFactory {

    protected final WebClient webClient;

    public AbstractTrendScrapperFactory(WebClient webClient) {
        this.webClient = webClient;
    }


}
