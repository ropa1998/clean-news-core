package implementations.scrappers.medium.article;

import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.DomElement;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import implementations.core.article.Article;
import implementations.core.article.IArticle;
import implementations.core.title.ITitle;
import implementations.scrappers.Utils;
import implementations.scrappers.medium.article.AbstractArticleScrapper;

import java.util.List;

public class BasicAbstractArticleScrapper extends AbstractArticleScrapper {


    public BasicAbstractArticleScrapper(WebClient webClient) {
        super(webClient);
    }

    @Override
    public IArticle scrap(ITitle title) {
        IArticle article = null;
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
            article = new Article(title.getTitle(), stringBuilder.toString(), title.getUrl(), title.getMedium());
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return article;
    }
}
