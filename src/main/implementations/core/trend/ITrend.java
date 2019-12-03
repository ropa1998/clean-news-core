package implementations.core.trend;

import implementations.core.region.IRegion;
import implementations.ISource;

public interface ITrend extends ISource {
    String getName();

    IRegion getRegion();
}
