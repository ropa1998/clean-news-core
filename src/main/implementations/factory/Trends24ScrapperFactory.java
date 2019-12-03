package implementations.factory;

import asbtract.TrendScrapperFactory;
import com.gargoylesoftware.htmlunit.WebClient;
import interfaces.Network;
import interfaces.Region;
import interfaces.TrendScrapper;

public class Trends24ScrapperFactory extends TrendScrapperFactory {

    public Trends24ScrapperFactory(WebClient webClient) {
        super(webClient);
    }

    @Override
    public TrendScrapper getArgentinaScrapper() {
        Region region = new implementations.core.Region("Argentina", "argentina");
        Network network = new implementations.scrappers.network.Network("https://trends24.in/");
        return new implementations.scrappers.trend.TrendScrapper(this.webClient, region, network);
    }
}
