package implementations.scrappers;

import com.gargoylesoftware.htmlunit.WebClient;
import implementations.factory.BasicMediumScrapperFactory;
import implementations.factory.WebClientFactory;
import implementations.flusher.FileFlusher;
import implementations.flusher.SoutFlusher;
import interfaces.*;
import org.apache.commons.lang3.time.StopWatch;
import org.junit.jupiter.api.Test;

class ScrapperTest {

    WebClient webClient;
    private final String directory = "src/test/implementations/scrappers/test-results/";
    private final String mockDirectory = "src/test/implementations/scrappers/mock-tests-results/";
    private final MediumScrapperFactory mediumScrapperFactory;

    public ScrapperTest() {
        WebClientFactory webClientFactory = new WebClientFactory();
        this.webClient = webClientFactory.getBasicWebClient();
        this.mediumScrapperFactory = new BasicMediumScrapperFactory(this.webClient);
    }

    @Test
    void Pagina12ScrapperTimeIs() {
        MediumScrapper pagina12Scrapper = this.mediumScrapperFactory.getPagina12Scrapper();
        long duration = ScrapperTimeTest(pagina12Scrapper);
        System.out.println(duration);
        Flusher flusher = new SoutFlusher();
        FlushArticles(flusher, pagina12Scrapper);
    }


    @Test
    void Pagina12RSSScrapperTimeIs() {
        MediumScrapper pagina12Scrapper = this.mediumScrapperFactory.getPagina12Scrapper();
        long duration = ScrapperTimeTest(pagina12Scrapper);
        System.out.println(duration);
    }

    @Test
    void FileFlusherWorks() {
        MediumScrapper pagina12Scrapper = this.mediumScrapperFactory.getPagina12Scrapper();
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
    void MockFileFlusherWorks() {
        Medium medium = new implementations.core.Medium("Fake Pagina12", "all fake", "really just fake");
        Article article = new implementations.core.Article("Lorem ipsum", "", "", medium);
        Flusher flusher = new FileFlusher(mockDirectory + "pagina12.txt");
        flusher.flush(article);
    }

    private long ScrapperTimeTest(MediumScrapper mediumScrapper) {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        mediumScrapper.run();
        stopWatch.stop();
        return stopWatch.getTime();
    }

    private void FlushArticles(Flusher flusher, MediumScrapper mediumScrapper) {
        for (Article article : mediumScrapper.getArticles()) {
            flusher.flush(article);
        }
    }

}