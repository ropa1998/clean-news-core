package asbtract;

import com.gargoylesoftware.htmlunit.WebClient;
import interfaces.Network;
import interfaces.Region;
import interfaces.Trend;

import java.util.HashSet;
import java.util.Set;

public abstract class TrendScrapper extends Scrapper implements interfaces.TrendScrapper {

    protected Set<Trend> trendSet;
    protected final Network network;
    protected final Region region;

    public TrendScrapper(WebClient webClient, Network network, Region region) {
        super(webClient);
        this.network = network;
        this.region = region;
        trendSet = new HashSet<>();
    }
}
