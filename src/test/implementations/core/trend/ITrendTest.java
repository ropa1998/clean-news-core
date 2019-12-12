package implementations.core.trend;

import implementations.core.region.IRegion;
import implementations.core.region.Region;
import org.junit.jupiter.api.Test;

import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ITrendTest {

    @Test
    public void SimpleTrendTest() {
        String trendString = "Trend";
        String name = "Lorem Ipsum";
        String url = "/loremIpsum";
        IRegion region = new Region(name, url);
        String scrappingUrl = "scrappingString";
        ITrend trend = new Trend(trendString, region, scrappingUrl);
        assertEquals(trend.getName(), trendString);
        assertEquals(trend.getRegion(), region);
        assertTrue(trend.getScrappingURL().equals(scrappingUrl));
    }

    @Test
    public void SimpleHashSetTrendTest() {
        String trendString = "Trend";
        String name = "Lorem Ipsum";
        String url = "/loremIpsum";
        IRegion region = new Region(name, url);
        String scrappingUrl = "scrappingString";
        ITrend trend = new Trend(trendString, region, scrappingUrl);
        HashSet<ITrend> trends = new HashSet<>();
        trends.add(trend);

        ITrend trend1 = new Trend("Hola", region, "SURL");
        trends.add(trend1);
    }

}