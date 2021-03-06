package implementations.core.title;

import implementations.core.medium.IMedium;

/**
 * A concrete class that implements AbstractTitle.
 */
public class Title extends AbstractTitle {

    public Title(IMedium medium, String title, String url) {
        super(medium, title, url);
    }
}
