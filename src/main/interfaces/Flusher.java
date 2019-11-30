package interfaces;

public interface Flusher {

    void flush(CleanNewsResult cleanNewsResult);

    void flush(Article article);

    void flush(Trend trend);

}
