package implementations.core;

public class Region implements interfaces.Region {

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
