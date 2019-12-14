package implementations.core.title;

import implementations.core.medium.IMedium;
import implementations.core.title.ITitle;

public abstract class AbstractTitle implements ITitle {

    private IMedium medium;
    private String title;
    private String url;

    /**
     * @param medium The IMedium to which this article belongs to.
     * @param title The name or title of the ITitle object.
     * @param url The url for accessing the article this title is referring to.
     */
    public AbstractTitle(IMedium medium, String title, String url) {
        this.medium = medium;
        this.title = title;
        this.url = url;
    }

    @Override
    public IMedium getMedium() {
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
