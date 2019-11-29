package interfaces;

import java.util.Set;

public interface MediumScrapper extends Runnable {
    Set<Article> getArticles();
}
