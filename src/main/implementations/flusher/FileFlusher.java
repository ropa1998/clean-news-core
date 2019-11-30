package implementations.flusher;

import interfaces.Article;
import interfaces.CleanNewsResult;
import interfaces.Flusher;
import interfaces.Trend;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;

public class FileFlusher implements Flusher {


    private File file;
    private String path;

    public FileFlusher(String path) {
        try {
            this.path = path;
            this.file = new File(path);
            if (!file.createNewFile()) {
                file.delete();
                file.createNewFile(); // if file already exists will do nothing
            }
            createHeader();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

    }

    private void createHeader() throws IOException {
        BufferedWriter output = new BufferedWriter(new FileWriter(file, true));

        output.write("///////////////////////////////////////////////////////////////////");
        output.newLine();
        output.write("BEGINING OF FILE");
        output.newLine();
        output.write("DATE: " + LocalDateTime.now().toString());
        output.newLine();
        output.write("///////////////////////////////////////////////////////////////////");

        output.newLine();

        output.flush();
        output.close();
    }

    @Override
    public void flush(CleanNewsResult cleanNewsResult) {

    }

    @Override
    public void flush(Article article) {
        try {
            BufferedWriter output = new BufferedWriter(new FileWriter(file, true));
            output.append("--------------------------------------");
            output.newLine();
            output.append("TITLE");
            output.newLine();
            output.append(article.getTitle());
            output.newLine();
            output.append("--------------------------------------");
            output.newLine();
            output.append("BODY");
            output.newLine();
            output.append(article.getBody());
            output.newLine();
            output.append("--------------------------------------");
            output.newLine();
            output.append("MEDIUM");
            output.newLine();
            output.append(article.getMedium().getName());
            output.newLine();
            output.append("--------------------------------------");
            output.newLine();
            output.newLine();
            output.flush();
            output.close();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    @Override
    public void flush(Trend trend) {

    }
}
