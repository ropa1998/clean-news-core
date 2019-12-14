package implementations.core.title;

import implementations.core.medium.IMedium;

public interface ITitle {

    /**
     * @return The name or title of the ITitle object.
     */
    String getTitle();

    /**
     * @return The IMedium to which this article belongs to.
     */
    IMedium getMedium();

    /**
     * @return The url for accessing the article this title is referring to.
     */
    String getUrl();
}
