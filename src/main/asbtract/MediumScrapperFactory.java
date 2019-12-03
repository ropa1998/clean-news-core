package asbtract;

import com.gargoylesoftware.htmlunit.WebClient;

public abstract class MediumScrapperFactory extends Scrapper implements interfaces.MediumScrapperFactory {

    public MediumScrapperFactory(WebClient webClient) {
        super(webClient);
    }
}
