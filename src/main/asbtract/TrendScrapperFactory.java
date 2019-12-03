package asbtract;


import com.gargoylesoftware.htmlunit.WebClient;

public abstract class TrendScrapperFactory implements interfaces.TrendScrapperFactory {

    protected final WebClient webClient;

    public TrendScrapperFactory(WebClient webClient) {
        this.webClient = webClient;
    }


}
