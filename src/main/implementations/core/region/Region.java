package implementations.core.region;

import implementations.core.region.IRegion;

public class Region implements IRegion {

    private String url;
    private String name;


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
