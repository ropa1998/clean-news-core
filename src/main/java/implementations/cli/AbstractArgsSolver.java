package implementations.cli;

public abstract class AbstractArgsSolver implements IArgsSolver {


    private String keyword;
    private String flag;

    public AbstractArgsSolver(String keyword, String flag) {
        this.keyword = keyword;
        this.flag = flag;
    }

    protected abstract void solve(String arg);

    @Override
    public void solve(String[] args) {
        boolean reading = false;

        for (int i = 0; i < args.length; i++) {
            if (args[i].contains(this.flag)) {
                if (args[i].contains(this.keyword)) {
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
}
