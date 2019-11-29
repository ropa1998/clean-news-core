

import com.gargoylesoftware.htmlunit.WebClient;
import implementations.scrappers.medium.Pagina12Scrapper;
import interfaces.Article;
import interfaces.MediumScrapper;

public class Main {

    public static void main(String[] args) {
        WebClient webClient = new WebClient();
        MediumScrapper laNacionScrapper = new Pagina12Scrapper(webClient);
        for (Article article : laNacionScrapper.getArticles()) {
            System.out.println("------------------------------------");
            System.out.println(article.getTitle());
            System.out.println(article.getBody());
            System.out.println("------------------------------------");
        }
    }
}
