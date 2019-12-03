package implementations.factory.trendScrapper;

import implementations.scrappers.trend.ITrendScrapper;

public interface ITrendScrapperFactory {

    ITrendScrapper getArgentinaScrapper();
}
