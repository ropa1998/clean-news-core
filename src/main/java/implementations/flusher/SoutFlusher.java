package implementations.flusher;

import implementations.core.article.IArticle;
import implementations.core.trend.ITrend;

/**
 * A flusher that shows the result in the console.
 */
public class SoutFlusher extends AbstractFlusher {

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";


    @Override
    public void flush(IArticle article) {
        System.out.println(ANSI_GREEN);
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
        System.out.println(ANSI_RESET);
    }

    @Override
    public void flush(ITrend trend) {
        System.out.println(ANSI_BLUE);
        System.out.println("\n");
        System.out.println("--------------------------------------");
        System.out.println("TREND");
        System.out.println(trend.getName());
        System.out.println("--------------------------------------");
        System.out.println("\n");
        System.out.println(ANSI_RESET);
    }
}
