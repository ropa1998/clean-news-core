package implementations.scrappers.medium.title;

import asbtract.Medium;
import asbtract.TitleScrapper;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.DomElement;
import com.gargoylesoftware.htmlunit.html.DomNodeList;
import com.gargoylesoftware.htmlunit.html.HtmlElement;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import implementations.scrappers.Utils;
import interfaces.Title;

import javax.management.InvalidAttributeValueException;
import java.util.List;
import java.util.Set;

public class BasicTitleScrapper extends TitleScrapper {


    public BasicTitleScrapper(WebClient webClient) {
        super(webClient);
    }

    @Override
    public Set<Title> scrap(Medium medium) {
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

                    implementations.core.Title title = new implementations.core.Title(medium, articleTitle, url);
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
