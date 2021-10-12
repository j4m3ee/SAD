package creational;

public class JSONBookMetadataExporter extends BookMetadataExporter {

    public BookMetadataFormatter createBookMetadataExporter() {
        return new JSONBookMetadataFormatter();
    }
}
