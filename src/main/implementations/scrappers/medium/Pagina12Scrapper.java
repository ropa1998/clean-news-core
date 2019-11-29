package implementations.scrappers.medium;

import asbtract.MediumScrapper;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.DomElement;
import com.gargoylesoftware.htmlunit.html.DomNodeList;
import com.gargoylesoftware.htmlunit.html.HtmlElement;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import implementations.core.Medium;
import implementations.core.Title;
import interfaces.Article;

import javax.management.InvalidAttributeValueException;
import java.util.List;
import java.util.Set;

public class Pagina12Scrapper extends MediumScrapper {


    public Pagina12Scrapper(WebClient webClient) {
        super(webClient, new Medium("Pagina12", "https://www.pagina12.com.ar/", ""));
    }

    @Override
    protected Set<interfaces.Title> scrapTitles() {
        try {
            HtmlPage htmlPage = webClient.getPage(medium.getScrapperStartingUrl());
            List<DomElement> allTitles = htmlPage.getByXPath(medium.getTitleKeyCSS());
            for (DomElement titleDomElem : allTitles) {

                String articleTitle = titleDomElem.getTextContent().trim();


                try {
                    String url = "";
                    DomNodeList<HtmlElement> a = titleDomElem.getElementsByTagName("a");


//                    for (HtmlElement htmlElement : a) {
//                        url = core.Utils.cleanURL(htmlElement.getAttribute("href"), medium);
//                    }

                    if (url.length() == 0) {
                        url = titleDomElem.getAttribute("href");
                    }


                    if (url.equals(medium.getScrapperStartingUrl())) {
                        throw new InvalidAttributeValueException("The url of a title cannot be equal to the homepage url");
                    }

                    Title title = new Title(medium, articleTitle, url);
                    titles.add(title);
                } catch (Exception e) {
                    System.err.println(e.getMessage());
                }
            }
        } catch (Exception e) {
            System.err.println(e.toString());
        }
        return this.titles;
    }

    @Override
    protected Article scrapArticle(interfaces.Title title) {
        return null;
    }


    @Override
    public Set<Article> getArticles() {
        return articles;
    }


}
