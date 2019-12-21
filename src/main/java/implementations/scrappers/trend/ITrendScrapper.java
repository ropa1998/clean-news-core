package implementations.scrappers.trend;

import implementations.IRunnable;
import implementations.core.trend.ITrend;

import java.util.Set;

public interface ITrendScrapper extends IRunnable {

    Set<ITrend> getTrends();

}
