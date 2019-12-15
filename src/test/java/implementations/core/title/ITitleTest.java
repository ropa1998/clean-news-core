package implementations.core.title;

import implementations.core.medium.IMedium;
import implementations.core.medium.Medium;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ITitleTest {

    @Test
    public void SimpleTitleTest() {
        String name = "Lorem Ipsum News";
        String url = "www.lorempipsum.com";
        String key = "lorem-ipsum-key";
        IMedium medium = new Medium(name, url, key);

        String titleUrl = "www.loremIpsumNews.com/lorem-ipsum";
        String titleName = "Lorem Ipsum!";
        ITitle title = new Title(medium, titleName, titleUrl);
        assertEquals(title.getMedium(), medium);
        assertEquals(title.getTitle(), titleName);
        assertEquals(title.getUrl(), titleUrl);

    }

}