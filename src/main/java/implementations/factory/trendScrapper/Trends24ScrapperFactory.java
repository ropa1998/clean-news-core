package implementations.factory.trendScrapper;

import com.gargoylesoftware.htmlunit.WebClient;
import implementations.core.region.Region;
import implementations.scrappers.trend.ITrendScrapper;
import implementations.scrappers.trend.network.INetwork;
import implementations.core.region.IRegion;

/**
 * An implementation of AbstractTrendScrapperFactory that retrieves the trends from trends24.in, a service that collects the Twitter trends.
 */
public class Trends24ScrapperFactory extends AbstractTrendScrapperFactory {

    public Trends24ScrapperFactory(WebClient webClient) {
        super(webClient);
    }

    @Override
    public ITrendScrapper getArgentinaScrapper() {
        IRegion region = new Region("Argentina", "argentina");
        INetwork network = new implementations.scrappers.trend.network.Network("https://trends24.in/");
        return new implementations.scrappers.trend.TrendScrapper(this.webClient, region, network);
    }
}
