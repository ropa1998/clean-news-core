package implementations.factory.mediumScrapper;

import com.gargoylesoftware.htmlunit.WebClient;
import implementations.core.medium.Medium;
import implementations.scrappers.medium.article.BasicAbstractArticleScrapper;
import implementations.scrappers.medium.title.RSSTitleScrapper;
import implementations.scrappers.medium.IMediumScrapper;


public class RSSMediumScrapperFactory extends AbstractMediumScrapperFactory {


    public RSSMediumScrapperFactory(WebClient webClient) {
        super(webClient);
    }

    @Override
    public IMediumScrapper getPagina12Scrapper() {
        return new implementations.scrappers.medium.MediumScrapper(this.webClient, new Medium("Pagina12 RSS", "https://www.pagina12.com.ar/rss/portada", "item"), new RSSTitleScrapper(this.webClient), new BasicAbstractArticleScrapper(this.webClient));
    }
}
