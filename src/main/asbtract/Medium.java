package asbtract;

public abstract class Medium implements interfaces.Medium {

    private final String name;
    private final String scrapperStartingUrl;
    private final String titleKeyCSS;

    public Medium(String name, String scrapperStartingUrl, String titleKeyCSS) {
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
