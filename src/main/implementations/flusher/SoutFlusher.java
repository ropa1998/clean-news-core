package implementations.flusher;

import implementations.core.article.IArticle;
import implementations.core.trend.ITrend;

public class SoutFlusher extends AbstractFlusher {


    @Override
    public void flush(IArticle article) {
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
    public void flush(ITrend trend) {
        System.out.println("\n");
        System.out.println("--------------------------------------");
        System.out.println("TREND");
        System.out.println(trend.getName());
        System.out.println("--------------------------------------");
        System.out.println("\n");
    }
}
