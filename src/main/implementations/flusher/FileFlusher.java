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
            writer.append("\n");
            writer.append("--------------------------------------");
            writer.append("TITLE");
            writer.append(article.getTitle());
            writer.append("--------------------------------------");
            writer.append("BODY");
            writer.append(article.getBody());
            writer.append("--------------------------------------");
            writer.append("MEDIUM");
            writer.append(article.getMedium().getName());
            writer.append("--------------------------------------");
            writer.append("\n");
            writer.close();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    @Override
    public void flush(Trend trend) {

    }
}
