package implementations.core.region;

public class Region implements IRegion {

    private String url;
    private String name;


    /**
     * @param name The name of the IRegion
     * @param url  The url of the region. This url depends directly on the service for getting the trends. This could be directly Twitter or a third party service.
     */
    public Region(String name, String url) {
        this.name = name;
        this.url = url;
    }


    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getUrl() {
        return url;
    }
}
