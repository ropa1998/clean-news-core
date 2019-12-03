package implementations.scrappers.medium.title;

import implementations.scrappers.AbstractScrapper;
import com.gargoylesoftware.htmlunit.WebClient;
import implementations.core.title.ITitle;

import java.util.HashSet;
import java.util.Set;

public abstract class AbstractTitleScrapper extends AbstractScrapper implements ITitleScrapper {

    protected Set<ITitle> titles;

    public AbstractTitleScrapper(WebClient webClient) {
        super(webClient);
        this.titles = new HashSet<>();
    }
}
