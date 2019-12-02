

//import com.gargoylesoftware.htmlunit.WebClient;
//import implementations.factory.WebClientFactory;
//import implementations.flusher.SoutFlusher;
//import implementations.scrappers.medium.Pagina12Scrapper;
//import interfaces.Article;
//import interfaces.Flusher;
//import interfaces.MediumScrapper;
//
//public class Main {
//
//    public static void main(String[] args) {
//        WebClientFactory webClientFactory = new WebClientFactory();
//        WebClient webClient = webClientFactory.getBasicWebClient();
//        MediumScrapper pagina12Scrapper = new Pagina12Scrapper(webClient);
//        Flusher flusher = new SoutFlusher();
//        pagina12Scrapper.run();
//        for (Article article : pagina12Scrapper.getArticles()) {
//            flusher.flush(article);
//        }
//    }
//}
