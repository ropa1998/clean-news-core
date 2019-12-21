package implementations.scrappers.medium.title.RSS;


import implementations.core.medium.IMedium;
import implementations.core.title.ITitle;
import implementations.core.title.Title;

import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.Characters;
import javax.xml.stream.events.XMLEvent;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashSet;
import java.util.Set;

public class RSSReader {
    private static final String TITLE = "title";
    private static final String DESCRIPTION = "description";
    private static final String LINK = "link";
    private static final String AUTHOR = "author";
    private String ITEM;

    private final URL url;
    private final IMedium medium;

    public RSSReader(IMedium medium) {
        try {
            this.url = new URL(medium.getScrapperStartingUrl());
            this.medium = medium;
            this.ITEM = medium.getTitleKeyCSS();
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

    private implementations.scrappers.medium.title.RSS.RSSFeed readFeed() {
        implementations.scrappers.medium.title.RSS.RSSFeed feed = null;
        try {
            boolean isFeedHeader = true;
            // Set header values intial to the empty string
            String description = "";
            String title = "";
            String link = "";
            String language = "";
            String copyright = "";
            String author = "";
            String pubdate = "";
            String guid = "";

            // First create a new XMLInputFactory
            XMLInputFactory inputFactory = XMLInputFactory.newInstance();
            // Setup a new eventReader
            InputStream in = read();
            XMLEventReader eventReader = inputFactory.createXMLEventReader(in);
            // read the XML document
            while (eventReader.hasNext()) {
                XMLEvent event = eventReader.nextEvent();
                if (event.isStartElement()) {
                    String localPart = event.asStartElement().getName()
                            .getLocalPart();
                    if (localPart.equals(ITEM)) {
                        if (isFeedHeader) {
                            isFeedHeader = false;
                            feed = new implementations.scrappers.medium.title.RSS.RSSFeed(title, link, description, language,
                                    copyright, pubdate);
                        }
                        //We must skip one, that's why it is suppressed
                        //noinspection UnusedAssignment
                        event = eventReader.nextEvent();
                    } else if (localPart.equals(TITLE)) {
                        title = getCharacterData(event, eventReader);
                    } else if (localPart.equals(DESCRIPTION)) {
                        description = getCharacterData(event, eventReader);
                    } else if (localPart.equals(LINK)) {
                        link = getLinkCharacterData(event, eventReader);
                    } else if (localPart.equals(AUTHOR)) {
                        author = getCharacterData(event, eventReader);
                    }
                } else if (event.isEndElement()) {
                    if (event.asEndElement().getName().getLocalPart().equals(ITEM)) {
                        FeedMessage message = new FeedMessage();
                        message.setAuthor(author);
                        message.setDescription(description);
                        message.setGuid(guid);
                        message.setLink(link);
                        message.setTitle(title);
                        feed.getMessages().add(message);
                        event = eventReader.nextEvent();
                    }
                }
            }
        } catch (XMLStreamException e) {
            throw new RuntimeException(e);
        }
        return feed;
    }

    private String getCharacterData(XMLEvent event, XMLEventReader eventReader)
            throws XMLStreamException {
        String result = "";
        event = eventReader.nextEvent();
        if (event instanceof Characters) {
            result = event.asCharacters().getData();
        }
        return result;
    }

    private String getLinkCharacterData(XMLEvent event, XMLEventReader eventReader) throws XMLStreamException {
        String result = getHREF(event.toString());
        if (result == null) {
            return getCharacterData(event, eventReader);
        }
        return result;
    }

    private String getHREF(String search) {
        String[] results = search.split("'");
        if (results.length > 2) {
            int i;
            for (i = 0; i < results.length; i++) {
                if (results[i].contains("href=")) break;
            }
            if (i + 1 < results.length) {
                return results[i + 1];
            }
        }
        return null;
    }

    public Set<ITitle> readTitles() {
        Set<ITitle> result = new HashSet<>();
        for (FeedMessage message : this.readFeed().entries) {
            ITitle title = new Title(medium, message.title, message.link);
            result.add(title);
        }
        return result;
    }


    private InputStream read() {
        try {
            System.setProperty("http.agent", "Chrome");
            HttpURLConnection uc = (HttpURLConnection) url.openConnection();
//            uc.addRequestProperty("User-Agent",
//                    "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.0)");
            uc.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows; U; Windows NT 6.1; en-GB;     rv:1.9.2.13) Gecko/20101203 Firefox/3.6.13 (.NET CLR 3.5.30729)");
            uc.connect();
            return uc.getInputStream();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
