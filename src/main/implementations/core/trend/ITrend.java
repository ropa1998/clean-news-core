package implementations.core.trend;

import implementations.ISource;
import implementations.core.region.IRegion;

public interface ITrend extends ISource {
    /**
     * @return The name of the ITrend
     */
    String getName();

    /**
     * @return The IRegion to which this ITrend belongs to.
     */
    IRegion getRegion();
}
