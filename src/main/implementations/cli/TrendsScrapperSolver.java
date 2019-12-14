package implementations.cli;

import implementations.factory.trendScrapper.ITrendScrapperFactory;
import implementations.scrappers.trend.ITrendScrapper;

import java.util.Set;

public class TrendsScrapperSolver implements IArgsSolver {

    private final ITrendScrapperFactory trendScrapperFactory;
    private final Set<ITrendScrapper> trendScrappers;

    public TrendsScrapperSolver(Set<ITrendScrapper> trendScrappers, ITrendScrapperFactory trendScrapperFactory) {
        this.trendScrappers = trendScrappers;
        this.trendScrapperFactory = trendScrapperFactory;
    }

    @Override
    public void solve(String[] args) {
        boolean reading = false;

        for (int i = 0; i < args.length; i++) {
            if (args[i].contains("-")) {
                if (args[i].contains("trends")) {
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
            case "argentina":
                trendScrappers.add(trendScrapperFactory.getArgentinaScrapper());
            default:

        }
    }
}
