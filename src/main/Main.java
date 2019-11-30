

import com.gargoylesoftware.htmlunit.WebClient;
import implementations.factory.WebClientFactory;
import implementations.scrappers.medium.Pagina12Scrapper;
import interfaces.Article;
import interfaces.MediumScrapper;

public class Main {

    public static void main(String[] args) {
        //TODO hacer bien el factory para WebClients.
        WebClientFactory webClientFactory = new WebClientFactory();
        WebClient webClient = webClientFactory.getBasicWebClient();
        MediumScrapper pagina12Scrapper = new Pagina12Scrapper(webClient);
        pagina12Scrapper.run();
        for (Article article : pagina12Scrapper.getArticles()) {
            System.out.println("------------------------------------");
            System.out.println(article.getTitle());
            System.out.println(article.getBody());
            System.out.println("------------------------------------");
        }
    }
}
