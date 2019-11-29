package implementations.scrappers.medium;

import asbtract.MediumScrapper;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import implementations.core.Medium;
import interfaces.Article;
import interfaces.Title;

import java.util.Set;

public class LaNacionScrapper extends MediumScrapper {


    public LaNacionScrapper(WebClient webClient) {
        super(webClient, new Medium("La Nacion", "", ""));
    }

    @Override
    protected Set<Title> scrapTitles() {
        try {
            HtmlPage htmlPage = webClient.getPage(medium.getScrapperStartingUrl());

        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return titles;
    }

    @Override
    protected Article scrapArticle(Title title) {
        return null;
    }

    @Override
    public Set<Article> getArticles() {
        return this.articles;
    }

}
