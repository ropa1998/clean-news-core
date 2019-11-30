package implementations.scrappers;

import com.gargoylesoftware.htmlunit.WebClient;
import implementations.factory.WebClientFactory;
import implementations.flusher.FileFlusher;
import implementations.flusher.SoutFlusher;
import implementations.scrappers.medium.Pagina12Scrapper;
import interfaces.Article;
import interfaces.Flusher;
import interfaces.Medium;
import interfaces.MediumScrapper;
import org.apache.commons.lang3.time.StopWatch;
import org.junit.jupiter.api.Test;

class ScrapperTest {

    WebClient webClient;
    private final String directory = "src/test/implementations/scrappers/test-results/";

    public ScrapperTest() {
        WebClientFactory webClientFactory = new WebClientFactory();
        this.webClient = webClientFactory.getBasicWebClient();
    }

    @Test
    void Pagina12ScrapperTimeIs() {
        MediumScrapper pagina12Scrapper = new Pagina12Scrapper(webClient);
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        pagina12Scrapper.run();
        stopWatch.stop();
        System.out.println(stopWatch.getTime());
        Flusher flusher = new SoutFlusher();
        for (Article article : pagina12Scrapper.getArticles()) {
            flusher.flush(article);
        }
    }

    @Test
    void FileFlusherWorks() {
        MediumScrapper pagina12Scrapper = new Pagina12Scrapper(webClient);
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        pagina12Scrapper.run();
        stopWatch.stop();
        System.out.println(stopWatch.getTime());
        Flusher flusher = new FileFlusher(directory + "pagina12.txt");
        for (Article article : pagina12Scrapper.getArticles()) {
            flusher.flush(article);
        }
    }

    @Test
    void FasterFileFlusherWorks() {
        Medium medium = new implementations.core.Medium("Fake Pagina12", "all fake", "really just fake");
        Article article = new implementations.core.Article("Lorem ipsum", "", "", medium);
        Flusher flusher = new FileFlusher(directory + "pagina12.txt");
        flusher.flush(article);

    }

}