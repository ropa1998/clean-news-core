package asbtract;

import com.gargoylesoftware.htmlunit.WebClient;
import interfaces.Article;
import interfaces.Title;

import java.util.HashSet;
import java.util.Set;

public abstract class MediumScrapper implements interfaces.MediumScrapper {

    protected Set<Article> articles;
    protected Set<Title> titles;
    protected Medium medium;
    protected WebClient webClient;

    public MediumScrapper(WebClient webClient, Medium medium) {
        this.medium = medium;
        articles = new HashSet<>();
        this.webClient = webClient;
    }

    @Override
    public void run() {
        this.titles = scrapTitles();
        for (Title title : this.titles) {
            Article article = scrapArticle(title);
            articles.add(article);
        }
    }

    protected abstract Set<Title> scrapTitles();

    protected abstract Article scrapArticle(Title title);
}
