package implementations.scrappers.medium.title;

import implementations.core.medium.AbstractMedium;
import implementations.core.title.ITitle;

import java.util.Set;

public interface ITitleScrapper {
    Set<ITitle> scrap(AbstractMedium medium);
}
