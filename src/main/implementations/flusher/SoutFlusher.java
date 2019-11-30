package implementations.flusher;

import interfaces.Article;
import interfaces.CleanNewsResult;
import interfaces.Flusher;
import interfaces.Trend;

public class SoutFlusher implements Flusher {


    @Override
    public void flush(CleanNewsResult cleanNewsResult) {

    }

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

    }
}
