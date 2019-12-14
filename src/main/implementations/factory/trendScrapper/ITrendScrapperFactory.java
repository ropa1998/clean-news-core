package implementations.factory.trendScrapper;

import implementations.scrappers.trend.ITrendScrapper;

public interface ITrendScrapperFactory {

    /**
     * @return A list of all the trends that were in the top ten for the region of Argentina
     */
    ITrendScrapper getArgentinaScrapper();
}
