package implementations.flusher;

import interfaces.Article;
import interfaces.CleanNewsResult;
import interfaces.Flusher;
import interfaces.Trend;

import java.io.PrintWriter;

public class FileFlusher implements Flusher {


    private final String path;

    public FileFlusher(String path) {
        this.path = path;
    }

    @Override
    public void flush(CleanNewsResult cleanNewsResult) {

    }

    @Override
    public void flush(Article article) {
        try {
            PrintWriter writer = new PrintWriter(this.path, "UTF-8");
            writer.println("\n");
            writer.println("--------------------------------------");
            writer.println("TITLE");
            writer.println(article.getTitle());
            writer.println("--------------------------------------");
            writer.println("BODY");
            writer.println(article.getBody());
            writer.println("--------------------------------------");
            writer.println("MEDIUM");
            writer.println(article.getMedium().getName());
            writer.println("--------------------------------------");
            writer.println("\n");
            writer.close();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    @Override
    public void flush(Trend trend) {

    }
}
