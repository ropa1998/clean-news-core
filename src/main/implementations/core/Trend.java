package implementations.core;

import implementations.scrappers.Utils;
import interfaces.Region;

public class Trend implements interfaces.Trend {

    private final String scrappingURL;
    private final String name;
    private final Region region;

    public Trend(String trend, interfaces.Region region, String scrappingURL) {
        this.name = Utils.cleanCamelCasing(trend.replace("#", ""), " ");
        this.region = region;
        this.scrappingURL = scrappingURL;
    }


    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public interfaces.Region getRegion() {
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
