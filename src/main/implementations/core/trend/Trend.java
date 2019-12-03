package implementations.core.trend;

import implementations.scrappers.Utils;
import implementations.core.region.IRegion;

public class Trend implements ITrend {

    private final String scrappingURL;
    private final String name;
    private final IRegion region;

    public Trend(String trend, IRegion region, String scrappingURL) {
        this.name = Utils.cleanCamelCasing(trend.replace("#", ""), " ");
        this.region = region;
        this.scrappingURL = scrappingURL;
    }


    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public IRegion getRegion() {
        return region;
    }

    @Override
    public String getScrappingURL() {
        return scrappingURL;
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return (obj instanceof Trend && ((Trend) obj).name.equals(this.name));

    }

    @Override
    public String toString() {
        return "Trend : " + this.name;
    }

}
