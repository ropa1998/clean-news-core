package asbtract;

import interfaces.Medium;

public abstract class Title implements interfaces.Title {

    private Medium medium;
    private String title;
    private String url;

    public Title(asbtract.Medium medium, String title, String url) {
        this.medium = medium;
        this.title = title;
        this.url = url;
    }

    @Override
    public Medium getMedium() {
        return medium;
    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public String getUrl() {
        return url;
    }
}
