package implementations.scrappers.trend;

import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.DomElement;
import com.gargoylesoftware.htmlunit.html.DomNodeList;
import com.gargoylesoftware.htmlunit.html.HtmlElement;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import interfaces.Network;
import interfaces.Region;
import interfaces.Trend;

import java.util.List;
import java.util.Set;

public class TrendScrapper extends asbtract.TrendScrapper {


    public TrendScrapper(WebClient webClient, Region region, Network network) {
        super(webClient, network, region);
    }

    @Override
    public Set<Trend> getTrends() {
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
                        trendSet.add(new implementations.core.Trend(element.getTextContent(), region, url));
                    }
                }
            }
        } catch (Exception e) {
            System.err.println(e.toString());
        }
    }
}
