package implementations.scrappers.trend.network;

public class Network implements interfaces.Network {


    private final String scrappingURL;

    public Network(String scrappingURL) {
        this.scrappingURL = scrappingURL;
    }

    @Override
    public String getScrappingURL() {
        return scrappingURL;
    }
}
