package implementations.scrappers.medium;

import asbtract.Medium;
import com.gargoylesoftware.htmlunit.WebClient;
import interfaces.Article;
import interfaces.ArticleScrapper;
import interfaces.Title;
import interfaces.TitleScrapper;

import java.util.HashSet;
import java.util.Set;

public class MediumScrapper implements interfaces.MediumScrapper {

    private final ArticleScrapper articleScrapper;
    private final TitleScrapper titleScrapper;
    protected Set<Article> articles;
    protected Set<Title> titles;
    protected Medium medium;
    protected WebClient webClient;

    public MediumScrapper(WebClient webClient, Medium medium, TitleScrapper titleScrapper, ArticleScrapper articleScrapper) {
        this.titles = new HashSet<>();
        this.medium = medium;
        articles = new HashSet<>();
        this.webClient = webClient;
        this.articleScrapper = articleScrapper;
        this.titleScrapper = titleScrapper;
    }

    @Override
    public void run() {
        this.titles = this.titleScrapper.scrap(this.medium);
        for (Title title : this.titles) {
            Article article = this.articleScrapper.scrap(title);
            if (article != null) {
                articles.add(article);
            }
        }
    }

    @Override
    public Set<Article> getArticles() {
        return articles;
    }
}
