package implementations.scrappers.medium.title;

import com.gargoylesoftware.htmlunit.WebClient;
import implementations.core.medium.AbstractMedium;
import implementations.core.title.ITitle;
import implementations.scrappers.medium.title.AbstractTitleScrapper;
import implementations.scrappers.medium.title.RSS.RSSReader;

import java.util.Set;

public class RSSTitleScrapper extends AbstractTitleScrapper {

    public RSSTitleScrapper(WebClient webClient) {
        super(webClient);
    }

    @Override
    public Set<ITitle> scrap(AbstractMedium medium) {
        RSSReader reader = new RSSReader(medium);
        return reader.readTitles();
    }
}
