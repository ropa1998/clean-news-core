package implementations.scrappers.medium;

import implementations.core.medium.AbstractMedium;
import com.gargoylesoftware.htmlunit.WebClient;
import implementations.core.article.IArticle;
import implementations.core.title.ITitle;
import implementations.scrappers.medium.article.IArticleScrapper;
import implementations.scrappers.medium.title.ITitleScrapper;

import java.util.HashSet;
import java.util.Set;

public class MediumScrapper implements IMediumScrapper {

    private final IArticleScrapper articleScrapper;
    private final ITitleScrapper titleScrapper;
    protected Set<IArticle> articles;
    protected Set<ITitle> titles;
    protected AbstractMedium medium;
    protected WebClient webClient;

    public MediumScrapper(WebClient webClient, AbstractMedium medium, ITitleScrapper titleScrapper, IArticleScrapper articleScrapper) {
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
        for (ITitle title : this.titles) {
            IArticle article = this.articleScrapper.scrap(title);
            if (article != null) {
                articles.add(article);
            }
        }
    }

    @Override
    public Set<IArticle> getArticles() {
        return articles;
    }
}
