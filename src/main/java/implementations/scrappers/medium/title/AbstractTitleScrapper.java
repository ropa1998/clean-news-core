package implementations.scrappers.medium.title;

import com.gargoylesoftware.htmlunit.WebClient;
import implementations.core.title.ITitle;
import implementations.scrappers.AbstractScrapper;
import implementations.scrappers.medium.title.ITitleScrapper;

import java.util.HashSet;
import java.util.Set;

public abstract class AbstractTitleScrapper extends AbstractScrapper implements ITitleScrapper {

    protected Set<ITitle> titles;

    public AbstractTitleScrapper(WebClient webClient) {
        super(webClient);
        this.titles = new HashSet<>();
    }
}
