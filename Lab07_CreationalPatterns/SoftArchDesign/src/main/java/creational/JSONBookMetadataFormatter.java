package creational;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.IOException;
import java.io.StringWriter;
import java.util.Arrays;
import java.util.stream.Stream;

public class JSONBookMetadataFormatter implements BookMetadataFormatter {

    private JSONArray bookList;
    private JSONObject bookObj;

    public JSONBookMetadataFormatter() {
        reset();
    }

    @Override
    public BookMetadataFormatter reset() {
        bookList = new JSONArray();
        bookObj = new JSONObject();
        bookObj.put(Book.class.getSimpleName() + "s", bookList);
        return this;
    }

    @Override
    public BookMetadataFormatter append(Book b) {
        JSONObject jsonData = new JSONObject();
        jsonData.put(Book.Metadata.ISBN.value,b.getISBN());
        jsonData.put(Book.Metadata.AUTHORS.value,Arrays.stream(b.getAuthors()).toList());
        jsonData.put(Book.Metadata.TITLE.value,b.getTitle());
        jsonData.put(Book.Metadata.PUBLISHER.value,b.getPublisher());

        bookList.add(jsonData);
        return this;
    }

    @Override
    public String getMetadataString() {
        return bookObj.toString();
    }
}
