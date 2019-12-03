package implementations.core.medium;

public abstract class AbstractMedium implements IMedium {

    private final String name;
    private final String scrapperStartingUrl;
    private final String titleKeyCSS;

    public AbstractMedium(String name, String scrapperStartingUrl, String titleKeyCSS) {
        this.titleKeyCSS = titleKeyCSS;
        this.name = name;
        this.scrapperStartingUrl = scrapperStartingUrl;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getScrapperStartingUrl() {
        return scrapperStartingUrl;
    }

    @Override
    public String getTitleKeyCSS() {
        return titleKeyCSS;
    }
}
