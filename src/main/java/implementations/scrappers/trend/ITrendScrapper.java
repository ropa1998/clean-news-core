package implementations.scrappers.trend;

import implementations.core.trend.ITrend;
import implementations.IRunnable;

import java.util.Set;

public interface ITrendScrapper extends IRunnable {

    Set<ITrend> getTrends();

}
