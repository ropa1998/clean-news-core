package implementations.factory.mediumScrapper;

import com.gargoylesoftware.htmlunit.WebClient;
import implementations.core.medium.Medium;
import implementations.scrappers.medium.article.BasicAbstractArticleScrapper;
import implementations.scrappers.medium.title.BasicTitleScrapper;
import implementations.scrappers.medium.IMediumScrapper;

/**
 * An AbstractMediumScrapperFactory that scraps media in the most simple way, just going to each of the home pages and reading the articles from the page.
 */
public class BasicMediumScrapperFactory extends AbstractMediumScrapperFactory {


    public BasicMediumScrapperFactory(WebClient webClient) {
        super(webClient);
    }


    @Override
    public IMediumScrapper getPagina12Scrapper() {
        return new implementations.scrappers.medium.MediumScrapper(this.webClient, new Medium("Pagina12", "https://www.pagina12.com.ar/", "//article"), new BasicTitleScrapper(this.webClient), new BasicAbstractArticleScrapper(this.webClient));
    }
}
