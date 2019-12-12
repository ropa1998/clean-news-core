package implementations.core.cleanNewsResult;

import implementations.core.article.Article;
import implementations.core.article.IArticle;
import implementations.core.medium.IMedium;
import implementations.core.medium.Medium;
import implementations.core.region.IRegion;
import implementations.core.region.Region;
import implementations.core.trend.ITrend;
import implementations.core.trend.Trend;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ICleanNewsResultTest {

    @Test
    public void SimpleCleanNewsResultTest() {
        ICleanNewsResult cleanNewsResult = new CleanNewsResult();

        String trendString = "Trend";
        String name = "Lorem Ipsum";
        String url = "/loremIpsum";
        IRegion region = new Region(name, url);
        String scrappingUrl = "scrappingString";
        ITrend trend = new Trend(trendString, region, scrappingUrl);

        String title = "Lorem Ipsum";
        String body = "Lorem ipsum dolor sit amet consectetur adipiscing elit massa, nisi tincidunt cubilia maecenas condimentum tempus tellus commodo euismod, neque cras sollicitudin mollis blandit egestas cursus. Metus senectus commodo purus placerat natoque aliquam quisque vestibulum, nisl laoreet praesent class integer rhoncus dapibus. Lobortis euismod nibh tempus elementum phasellus augue vel dui netus, nulla tristique pulvinar habitasse fames mauris pretium semper, dapibus a malesuada turpis felis tortor velit arcu.\n" +
                "\n" +
                "Nisi ultricies dis commodo in libero morbi faucibus ac ornare venenatis facilisi leo sociis, luctus volutpat integer pulvinar cras suscipit potenti class convallis suspendisse urna. Suscipit fusce curae volutpat penatibus laoreet fringilla sociis accumsan sodales ad risus, eget urna enim lacinia hac proin dignissim ut taciti. Vivamus nec dictumst vestibulum cum ultrices a, tempus mattis laoreet torquent tempor, purus rhoncus hac mollis mauris.";
        String articleUrl = "www.loremipsum.com";
        IMedium medium = new Medium("Dummy Medium", "dummyString", "DummyKey");

        IArticle article = new Article(title, body, articleUrl, medium);

        cleanNewsResult.add(trend, article);
        cleanNewsResult.add(trend, article);

        Map<ITrend, List<IArticle>> map = cleanNewsResult.getMap();
        assertEquals(1, map.keySet().size());
        assertEquals(2, map.get(trend).size());
    }

}