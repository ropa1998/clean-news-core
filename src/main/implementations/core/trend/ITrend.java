package implementations.core.trend;

import implementations.ISource;
import implementations.core.region.IRegion;

public interface ITrend extends ISource {
    String getName();
    IRegion getRegion();
}
