package interfaces;

import java.time.LocalDateTime;
import java.util.Set;

public interface Article {

    String getTitle();

    String getBody();

    String getUrl();

    Set<Trend> getTrends();

    Medium getMedium();

    LocalDateTime getDate();
}
