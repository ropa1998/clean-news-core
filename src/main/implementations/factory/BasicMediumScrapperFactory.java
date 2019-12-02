package implementations.factory;

import com.gargoylesoftware.htmlunit.WebClient;
import implementations.core.Medium;
import implementations.scrappers.medium.article.BasicArticleScrapper;
import implementations.scrappers.medium.title.BasicTitleScrapper;
import interfaces.MediumScrapper;
import interfaces.MediumScrapperFactory;

public class BasicMediumScrapperFactory implements MediumScrapperFactory {

    private final WebClient webClient;

    public BasicMediumScrapperFactory(WebClient webClient) {
        this.webClient = webClient;
    }

    @Override
    public MediumScrapper getPagina12Scrapper() {
        return new implementations.scrappers.medium.MediumScrapper(webClient, new Medium("Pagina12", "https://www.pagina12.com.ar/", "//article"), new BasicTitleScrapper(this.webClient), new BasicArticleScrapper(this.webClient));
    }
}
