package implementations.factory.mediumScrapper;

import com.gargoylesoftware.htmlunit.WebClient;
import implementations.core.medium.Medium;
import implementations.scrappers.medium.IMediumScrapper;
import implementations.scrappers.medium.MediumScrapper;
import implementations.scrappers.medium.article.BasicAbstractArticleScrapper;
import implementations.scrappers.medium.title.RSSTitleScrapper;


public class RSSMediumScrapperFactory extends AbstractMediumScrapperFactory {


    public RSSMediumScrapperFactory(WebClient webClient) {
        super(webClient);
    }

    @Override
    public IMediumScrapper getPagina12Scrapper() {
        return new implementations.scrappers.medium.MediumScrapper(this.webClient, new Medium("Pagina12 RSS", "https://www.pagina12.com.ar/rss/portada", "item"), new RSSTitleScrapper(this.webClient), new BasicAbstractArticleScrapper(this.webClient));
    }

    @Override
    public IMediumScrapper getLaNacionScrapper() {
        return new MediumScrapper(this.webClient, new Medium("La Nacion", "http://contenidos.lanacion.com.ar/herramientas/rss/origen=2", "entry"), new RSSTitleScrapper(this.webClient), new BasicAbstractArticleScrapper(this.webClient));
    }

    @Override
    public IMediumScrapper getNYTAmericasScrapper() {
        return new MediumScrapper(this.webClient, new Medium("NYT Americas", "https://rss.nytimes.com/services/xml/rss/nyt/Americas.xml", "item"), new RSSTitleScrapper(this.webClient), new BasicAbstractArticleScrapper(this.webClient));
    }


}
