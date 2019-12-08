

import com.gargoylesoftware.htmlunit.WebClient;
import implementations.core.article.Article;
import implementations.core.article.IArticle;
import implementations.core.medium.IMedium;
import implementations.core.medium.Medium;
import implementations.core.region.IRegion;
import implementations.core.region.Region;
import implementations.core.trend.ITrend;
import implementations.factory.mediumScrapper.IMediumScrapperFactory;
import implementations.factory.mediumScrapper.RSSMediumScrapperFactory;
import implementations.scrappers.trend.ITrendScrapper;
import implementations.factory.webclient.WebClientFactory;
import implementations.flusher.FileFlusher;
import implementations.flusher.IFlusher;
import implementations.flusher.SoutFlusher;
import implementations.scrappers.medium.IMediumScrapper;
import implementations.scrappers.trend.network.INetwork;
import org.apache.commons.lang3.time.StopWatch;
import org.junit.jupiter.api.Test;

class ScrapperTest {

    WebClient webClient;
    private final String directory = "src/test/results/real/";
    private final String mockDirectory = "src/test/results/mock/";
    private final IMediumScrapperFactory mediumScrapperFactory;

    public ScrapperTest() {
        WebClientFactory webClientFactory = new WebClientFactory();
        this.webClient = webClientFactory.getBasicWebClient();
        this.mediumScrapperFactory = new RSSMediumScrapperFactory(this.webClient);
    }

    @Test
    void Pagina12ScrapperTimeIs() {
        IMediumScrapper pagina12Scrapper = this.mediumScrapperFactory.getPagina12Scrapper();
        long duration = ScrapperTimeTest(pagina12Scrapper);
        System.out.println(duration);
        IFlusher flusher = new SoutFlusher();
        FlushArticles(flusher, pagina12Scrapper);
    }


    @Test
    void Pagina12RSSScrapperTimeIs() {
        IMediumScrapper pagina12Scrapper = this.mediumScrapperFactory.getPagina12Scrapper();
        long duration = ScrapperTimeTest(pagina12Scrapper);
        System.out.println(duration);
        IFlusher flusher = new SoutFlusher();
        FlushArticles(flusher, pagina12Scrapper);
    }

    @Test
    void FileFlusherWorks() {
        IMediumScrapper pagina12Scrapper = this.mediumScrapperFactory.getPagina12Scrapper();
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        pagina12Scrapper.run();
        stopWatch.stop();
        System.out.println(stopWatch.getTime());
        IFlusher flusher = new FileFlusher(directory + "pagina12.txt");
        for (IArticle article : pagina12Scrapper.getArticles()) {
            flusher.flush(article);
        }
    }

    @Test
    void MockFileFlusherWorks() {
        IMedium medium = new Medium("Fake Pagina12", "all fake", "really just fake");
        IArticle article = new Article("Lorem ipsum", "", "", medium);
        IFlusher flusher = new FileFlusher(mockDirectory + "pagina12.txt");
        flusher.flush(article);
    }

    @Test
    void TrendsProperlyScrapped() {
        IRegion region = new Region("Argentina", "argentina");
        INetwork network = new implementations.scrappers.trend.network.Network("https://trends24.in/");
        ITrendScrapper trendScrapper = new implementations.scrappers.trend.TrendScrapper(webClient, region, network);
        trendScrapper.run();
        IFlusher flusher = new SoutFlusher();
        for (ITrend trend : trendScrapper.getTrends()) {
            flusher.flush(trend);
        }
    }

    private long ScrapperTimeTest(IMediumScrapper mediumScrapper) {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        mediumScrapper.run();
        stopWatch.stop();
        return stopWatch.getTime();
    }

    private void FlushArticles(IFlusher flusher, IMediumScrapper mediumScrapper) {
        for (IArticle article : mediumScrapper.getArticles()) {
            flusher.flush(article);
        }
    }

}