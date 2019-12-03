package implementations.flusher;

import asbtract.Flusher;
import interfaces.Article;
import interfaces.Trend;

public class SoutFlusher extends Flusher {


    @Override
    public void flush(Article article) {
        System.out.println("\n");
        System.out.println("--------------------------------------");
        System.out.println("TITLE");
        System.out.println(article.getTitle());
        System.out.println("--------------------------------------");
        System.out.println("BODY");
        System.out.println(article.getBody());
        System.out.println("--------------------------------------");
        System.out.println("MEDIUM");
        System.out.println(article.getMedium().getName());
        System.out.println("--------------------------------------");
        System.out.println("\n");
    }

    @Override
    public void flush(Trend trend) {
        System.out.println("\n");
        System.out.println("--------------------------------------");
        System.out.println("TREND");
        System.out.println(trend.getName());
        System.out.println("--------------------------------------");
        System.out.println("\n");
    }
}
