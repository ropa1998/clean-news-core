package implementations.scrappers.trend;

import implementations.scrappers.AbstractScrapper;
import com.gargoylesoftware.htmlunit.WebClient;
import implementations.scrappers.trend.network.INetwork;
import implementations.core.region.IRegion;
import implementations.core.trend.ITrend;

import java.util.HashSet;
import java.util.Set;

public abstract class AbstractTrendScrapper extends AbstractScrapper implements ITrendScrapper {

    protected Set<ITrend> trendSet;
    protected final INetwork network;
    protected final IRegion region;

    public AbstractTrendScrapper(WebClient webClient, INetwork network, IRegion region) {
        super(webClient);
        this.network = network;
        this.region = region;
        trendSet = new HashSet<>();
    }
}
