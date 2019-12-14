package implementations;

public interface ISource {
    /**
     * @return The URL from which a source should be scrapped from
     */
    String getScrappingURL();
}
