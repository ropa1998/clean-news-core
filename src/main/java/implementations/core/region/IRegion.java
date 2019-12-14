package implementations.core.region;

public interface IRegion {
    /**
     * @return The name of the IRegion
     */
    String getName();

    /**
     * @return The url of the region. This url depends directly on the service for getting the trends. This could be directly Twitter or a third party service.
     */
    String getUrl();
}
