package interfaces;

import java.util.List;
import java.util.Map;

public interface CleanNewsResult {

    Map<Trend, List<Article>> getMap();

    void add(Trend trend, Article article);

}
