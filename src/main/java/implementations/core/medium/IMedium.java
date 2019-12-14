package implementations.core.medium;

/**
 * The interface all mediums should be able to answer to
 */
public interface IMedium {

    /**
     * @return The url from which the medium should be scrapped from. This could be the home page of the medium or the RSS feed page.
     */
    String getScrapperStartingUrl();

    /**
     * @return The name of the IMedium
     */
    String getName();

    /**
     * @return The key that the medium uses to identify its titles, either in the home page or the RSS Feed.
     */
    String getTitleKeyCSS();

}
