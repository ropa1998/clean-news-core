package interfaces;

import asbtract.Medium;

import java.util.Set;

public interface TitleScrapper {
    Set<Title> scrap(Medium medium);
}
