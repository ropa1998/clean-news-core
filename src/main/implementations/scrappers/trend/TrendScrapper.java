package implementations.scrappers.trend;

import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.DomElement;
import com.gargoylesoftware.htmlunit.html.DomNodeList;
import com.gargoylesoftware.htmlunit.html.HtmlElement;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import implementations.core.trend.Trend;
import implementations.scrappers.trend.network.INetwork;
import implementations.core.region.IRegion;
import implementations.core.trend.ITrend;

import java.util.List;
import java.util.Set;

public class TrendScrapper extends AbstractTrendScrapper {


    public TrendScrapper(WebClient webClient, IRegion region, INetwork network) {
        super(webClient, network, region);
    }

    @Override
    public Set<ITrend> getTrends() {
        return this.trendSet;
    }

    @Override
    public void run() {
        String url = network.getScrappingURL() + region.getUrl();
        try {
            HtmlPage htmlPage = webClient.getPage(url);
            List<DomElement> trendList = htmlPage.getElementsById("trend-list");
            for (DomElement domElement : trendList) {
                DomNodeList<HtmlElement> li = domElement.getElementsByTagName("li");
                for (HtmlElement htmlElement : li) {
                    DomNodeList<HtmlElement> a = htmlElement.getElementsByTagName("a");
                    for (HtmlElement element : a) {
                        System.out.println(element.getTextContent());
                        trendSet.add(new Trend(element.getTextContent(), region, url));
                    }
                }
            }
        } catch (Exception e) {
            System.err.println(e.toString());
        }
    }
}
