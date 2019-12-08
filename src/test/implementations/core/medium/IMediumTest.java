package implementations.core.medium;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class IMediumTest {

    @Test
    public void SimpleMediumTest() {
        String name = "Lorem Ipsum News";
        String url = "www.lorempipsum.com";
        String key = "lorem-ipsum-key";
        IMedium medium = new Medium(name, url, key);
        assertEquals(medium.getName(), name);
        assertEquals(medium.getScrapperStartingUrl(), url);
        assertEquals(medium.getTitleKeyCSS(), key);
    }

}