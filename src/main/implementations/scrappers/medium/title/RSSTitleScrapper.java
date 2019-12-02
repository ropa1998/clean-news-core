package implementations.scrappers.medium.title;

import asbtract.Medium;
import asbtract.TitleScrapper;
import com.gargoylesoftware.htmlunit.WebClient;
import implementations.scrappers.medium.title.RSS.RSSReader;
import interfaces.Title;

import java.util.Set;

public class RSSTitleScrapper extends TitleScrapper {

    public RSSTitleScrapper(WebClient webClient) {
        super(webClient);
    }

    @Override
    public Set<Title> scrap(Medium medium) {
        RSSReader reader = new RSSReader(medium);
        return reader.readTitles();
    }
}
