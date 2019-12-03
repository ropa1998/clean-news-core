package implementations.factory;

import asbtract.MediumScrapperFactory;
import com.gargoylesoftware.htmlunit.WebClient;
import implementations.core.Medium;
import implementations.scrappers.medium.article.BasicArticleScrapper;
import implementations.scrappers.medium.title.BasicTitleScrapper;
import interfaces.MediumScrapper;

public class BasicMediumScrapperFactory extends MediumScrapperFactory {


    public BasicMediumScrapperFactory(WebClient webClient) {
        super(webClient);
    }


    @Override
    public MediumScrapper getPagina12Scrapper() {
        return new implementations.scrappers.medium.MediumScrapper(this.webClient, new Medium("Pagina12", "https://www.pagina12.com.ar/", "//article"), new BasicTitleScrapper(this.webClient), new BasicArticleScrapper(this.webClient));
    }
}
