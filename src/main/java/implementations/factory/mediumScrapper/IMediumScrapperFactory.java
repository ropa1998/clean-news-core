package implementations.factory.mediumScrapper;

import implementations.scrappers.medium.IMediumScrapper;

/**
 * A factory interface with methods to create all supported IMedium
 */
public interface IMediumScrapperFactory {

    /**
     * @return A IMediumScrapper that scraps the argentinian newspaper Pagina12
     */
    IMediumScrapper getPagina12Scrapper();

    /**
     * @return IMediumScrapper that scraps the argentinian newspaper LaNacion
     */
    IMediumScrapper getLaNacionScrapper();


}
