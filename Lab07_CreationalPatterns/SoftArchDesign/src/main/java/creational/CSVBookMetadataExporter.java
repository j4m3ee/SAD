package creational;

import java.io.IOException;

public class CSVBookMetadataExporter extends BookMetadataExporter {

    public BookMetadataFormatter createBookMetadataExporter() throws IOException {
        return new CSVBookMetadataFormatter();
    }
}
