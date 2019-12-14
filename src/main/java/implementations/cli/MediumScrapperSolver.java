package implementations.cli;

import implementations.factory.mediumScrapper.IMediumScrapperFactory;
import implementations.scrappers.medium.IMediumScrapper;

import java.util.Set;

public class MediumScrapperSolver implements IArgsSolver {
    private final IMediumScrapperFactory mediumScrapperFactory;
    private final Set<IMediumScrapper> mediumScrappers;

    public MediumScrapperSolver(Set<IMediumScrapper> mediumScrappers, IMediumScrapperFactory mediumScrapperFactory) {
        this.mediumScrappers = mediumScrappers;
        this.mediumScrapperFactory = mediumScrapperFactory;
    }

    @Override
    public void solve(String[] args) {
        boolean reading = false;

        for (int i = 0; i < args.length; i++) {
            if (args[i].contains("-")) {
                if (args[i].contains("media")) {
                    reading = true;
                    i = i + 1;
                } else {
                    reading = false;
                }
            }

            if (reading) {
                solve(args[i]);
            }

        }
    }

    private void solve(String arg) {
        switch (arg) {
            case "lanacion":
                mediumScrappers.add(mediumScrapperFactory.getLaNacionScrapper());
                break;
            case "pagina12":
                mediumScrappers.add(mediumScrapperFactory.getPagina12Scrapper());
                break;
            default:

        }
    }
}
