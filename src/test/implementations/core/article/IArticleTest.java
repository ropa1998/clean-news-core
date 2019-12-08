package implementations.core.article;

import implementations.core.medium.IMedium;
import implementations.core.medium.Medium;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class IArticleTest {


    @Test
    public void SimpleArticleTest() {
        String title = "Lorem Ipsum";
        String body = "Lorem ipsum dolor sit amet consectetur adipiscing elit massa, nisi tincidunt cubilia maecenas condimentum tempus tellus commodo euismod, neque cras sollicitudin mollis blandit egestas cursus. Metus senectus commodo purus placerat natoque aliquam quisque vestibulum, nisl laoreet praesent class integer rhoncus dapibus. Lobortis euismod nibh tempus elementum phasellus augue vel dui netus, nulla tristique pulvinar habitasse fames mauris pretium semper, dapibus a malesuada turpis felis tortor velit arcu.\n" +
                "\n" +
                "Nisi ultricies dis commodo in libero morbi faucibus ac ornare venenatis facilisi leo sociis, luctus volutpat integer pulvinar cras suscipit potenti class convallis suspendisse urna. Suscipit fusce curae volutpat penatibus laoreet fringilla sociis accumsan sodales ad risus, eget urna enim lacinia hac proin dignissim ut taciti. Vivamus nec dictumst vestibulum cum ultrices a, tempus mattis laoreet torquent tempor, purus rhoncus hac mollis mauris.";
        String url = "www.loremipsum.com";
        IMedium medium = new Medium("Dummy Medium", "dummyString", "DummyKey");

        IArticle article = new Article(title, body, url, medium);

        assertEquals(article.getTitle(), title);
        assertEquals(article.getBody(), body);
//        assertTrue(article.getDate().isBefore(LocalDateTime.now()));
        assertEquals(article.getMedium(), medium);
        assertEquals(article.getUrl(), url);
        assertEquals(article.getTrends(), new HashSet<>());
    }

}