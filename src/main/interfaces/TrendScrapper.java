package interfaces;

import java.util.Set;

public interface TrendScrapper extends Runnable {

    Set<Trend> getTrends();

}
