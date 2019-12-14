package implementations.flusher;

import implementations.core.article.IArticle;
import implementations.core.trend.ITrend;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;

/**
 * A flusher that puts all of the content in a specific file
 */
public class FileFlusher extends AbstractFlusher {


    private File file;
    private String path;

    /**
     * @param path The path to the file where you want to save the result of the flusher
     */
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

    /**
     * @throws IOException
     * Creates the header in the file with information of the date and time it was created
     */
    private void createHeader() throws IOException {
        BufferedWriter output = new BufferedWriter(new FileWriter(file, true));

        output.write("///////////////////////////////////////////////////////////////////");
        output.newLine();
        output.write("BEGINNING OF FILE");
        output.newLine();
        output.write("DATE: " + LocalDateTime.now().toString());
        output.newLine();
        output.write("///////////////////////////////////////////////////////////////////");

        output.newLine();

        output.flush();
        output.close();
    }


    @Override
    public void flush(IArticle article) {
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
    public void flush(ITrend trend) {
        try {
            BufferedWriter output = new BufferedWriter(new FileWriter(file, true));
            output.append("--------------------------------------");
            output.newLine();
            output.append("TREND");
            output.newLine();
            output.append(trend.getName());
            output.newLine();
            output.append("--------------------------------------");
            output.flush();
            output.close();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}
