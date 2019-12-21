package implementations.scrappers.trend.network;

import implementations.scrappers.trend.network.INetwork;

public class Network implements INetwork {


    private final String scrappingURL;

    public Network(String scrappingURL) {
        this.scrappingURL = scrappingURL;
    }

    @Override
    public String getScrappingURL() {
        return scrappingURL;
    }
}
