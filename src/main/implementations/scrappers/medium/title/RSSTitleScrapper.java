package implementations.scrappers.medium.title;

import implementations.core.medium.AbstractMedium;
import com.gargoylesoftware.htmlunit.WebClient;
import implementations.scrappers.medium.title.RSS.RSSReader;
import implementations.core.title.ITitle;

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
