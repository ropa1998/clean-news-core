package implementations.core.region;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class IRegionTest {

    @Test
    public void simpleRegionTest() {
        String name = "Lorem Ipsum";
        String url = "/loremIpsum";
        IRegion region = new Region(name, url);
        assertEquals(region.getName(), name);
        assertEquals(region.getUrl(), url);
    }

}