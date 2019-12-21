package implementations.scrappers.medium.title;

import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.DomElement;
import com.gargoylesoftware.htmlunit.html.DomNodeList;
import com.gargoylesoftware.htmlunit.html.HtmlElement;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import implementations.core.medium.AbstractMedium;
import implementations.core.title.ITitle;
import implementations.core.title.Title;
import implementations.scrappers.Utils;
import implementations.scrappers.medium.title.AbstractTitleScrapper;

import javax.management.InvalidAttributeValueException;
import java.util.List;
import java.util.Set;

public class BasicTitleScrapper extends AbstractTitleScrapper {


    public BasicTitleScrapper(WebClient webClient) {
        super(webClient);
    }

    @Override
    public Set<ITitle> scrap(AbstractMedium medium) {
        try {
            HtmlPage htmlPage = webClient.getPage(medium.getScrapperStartingUrl());
            List<DomElement> allTitles = htmlPage.getByXPath(medium.getTitleKeyCSS());
            for (DomElement titleDomElem : allTitles) {

                String articleTitle = titleDomElem.getTextContent().trim();


                try {
                    String url = "";
                    DomNodeList<HtmlElement> a = titleDomElem.getElementsByTagName("a");


                    for (HtmlElement htmlElement : a) {
                        url = Utils.cleanURL(htmlElement.getAttribute("href"), medium);
                    }

                    if (url.length() == 0) {
                        url = titleDomElem.getAttribute("href");
                    }


                    if (url.equals(medium.getScrapperStartingUrl())) {
                        throw new InvalidAttributeValueException("The url of a title cannot be equal to the homepage url");
                    }

                    Title title = new Title(medium, articleTitle, url);
                    this.titles.add(title);
                } catch (Exception e) {
                    System.err.println(e.getMessage());
                }
            }
        } catch (Exception e) {
            System.err.println(e.toString());
        }
        return this.titles;
    }
}
