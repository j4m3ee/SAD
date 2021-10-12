package creational;

import javax.xml.parsers.ParserConfigurationException;

public class XMLBookMetadataExporter extends BookMetadataExporter {

    public BookMetadataFormatter createBookMetadataExporter() throws ParserConfigurationException {
        return new XMLBookMetadataFormatter();
    }
}
