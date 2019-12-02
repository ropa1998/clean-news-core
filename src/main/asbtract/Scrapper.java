package asbtract;

import com.gargoylesoftware.htmlunit.WebClient;

public abstract class Scrapper {

    protected final WebClient webClient;

    public Scrapper(WebClient webClient) {
        this.webClient = webClient;
    }
}
