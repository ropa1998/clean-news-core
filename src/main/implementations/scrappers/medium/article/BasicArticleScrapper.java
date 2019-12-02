package implementations.scrappers.medium.article;

import asbtract.ArticleScrapper;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.DomElement;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import implementations.scrappers.Utils;
import interfaces.Article;
import interfaces.Title;

import java.util.List;

public class BasicArticleScrapper extends ArticleScrapper {


    public BasicArticleScrapper(WebClient webClient) {
        super(webClient);
    }

    @Override
    public Article scrap(Title title) {
        Article article = null;
        try {
            HtmlPage htmlPage = this.webClient.getPage(title.getUrl());
            List<DomElement> paragraphs = htmlPage.getByXPath("//p");
            StringBuilder stringBuilder = new StringBuilder();
            for (DomElement paragraph : paragraphs) {
                if (paragraph.getTextContent().length() > 20) {
                    String paragraphText = paragraph.getTextContent();
                    paragraphText = paragraphText.replace("\n", " ");
                    paragraphText = Utils.cleanExtraSpacesInString(paragraphText);
                    stringBuilder.append(paragraphText);
                    stringBuilder.append("\n");
                }
            }
            if (stringBuilder.length() == 0) {
                stringBuilder.append("<Empty body>");
            }
            article = new implementations.core.Article(title.getTitle(), stringBuilder.toString(), title.getUrl(), title.getMedium());
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return article;
    }
}
