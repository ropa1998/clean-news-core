package asbtract;

import com.gargoylesoftware.htmlunit.WebClient;

public abstract class ArticleScrapper extends Scrapper implements interfaces.ArticleScrapper {

    public ArticleScrapper(WebClient webClient) {
        super(webClient);
    }

}
