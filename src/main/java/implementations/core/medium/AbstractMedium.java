package implementations.core.medium;

public abstract class AbstractMedium implements IMedium {

    private final String name;
    private final String scrapperStartingUrl;
    private final String titleKeyCSS;

    /**
     * @param name                The name of the Medium
     * @param scrapperStartingUrl The url from which the medium should be scrapped from. This could be the home page of the medium or the RSS feed page.
     * @param titleKeyCSS         The key that the medium uses to identify its titles, either in the home page or the RSS Feed.
     */
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

    @Override
    public String toString() {
        return name;
    }
}
