package implementations.factory;

import asbtract.MediumScrapperFactory;
import com.gargoylesoftware.htmlunit.WebClient;
import implementations.core.Medium;
import implementations.scrappers.medium.article.BasicArticleScrapper;
import implementations.scrappers.medium.title.RSSTitleScrapper;
import interfaces.MediumScrapper;


public class RSSMediumScrapperFactory extends MediumScrapperFactory {


    public RSSMediumScrapperFactory(WebClient webClient) {
        super(webClient);
    }

    @Override
    public MediumScrapper getPagina12Scrapper() {
        return new implementations.scrappers.medium.MediumScrapper(this.webClient, new Medium("Pagina12 RSS", "https://www.pagina12.com.ar/rss/portada", "item"), new RSSTitleScrapper(this.webClient), new BasicArticleScrapper(this.webClient));
    }
}
