package asbtract;

import com.gargoylesoftware.htmlunit.WebClient;
import interfaces.Title;

import java.util.HashSet;
import java.util.Set;

public abstract class TitleScrapper extends Scrapper implements interfaces.TitleScrapper {

    protected Set<Title> titles;

    public TitleScrapper(WebClient webClient) {
        super(webClient);
        this.titles = new HashSet<>();
    }
}
