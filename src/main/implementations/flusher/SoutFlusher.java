package implementations.flusher;

import interfaces.Article;
import interfaces.CleanNewsResult;
import interfaces.Flusher;
import interfaces.Trend;

import java.util.List;
import java.util.Map;

public class SoutFlusher implements Flusher {


    @Override
    public void flush(CleanNewsResult cleanNewsResult) {
        Map<Trend, List<Article>> map = cleanNewsResult.getMap();
        for (Trend trend : map.keySet()) {
            flush(trend);
            for (Article article : map.get(trend)) {
                flush(article);
            }
        }
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
        System.out.println("\n");
        System.out.println("--------------------------------------");
        System.out.println("TREND");
        System.out.println(trend.getName());
        System.out.println("--------------------------------------");
        System.out.println("\n");
    }
}
