package interfaces;

import java.util.Set;

public interface Article {

    String getTitle();
    String getBody();
    String getUrl();
    Set<Trend> getTrends();

}
