package com.labs.io;

import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializer;
import com.labs.adapter.RuntimeTypeAdapterFactory;
import com.labs.model.Book;
import com.labs.model.Library;
import com.labs.model.TextBook;
import com.labs.model.Vocabulary;

import javax.xml.bind.JAXBException;
import java.io.*;
import java.time.Year;

public class JSONLibrary implements IO{
    @Override
    public void serialize(Library library, String path) throws JAXBException, IOException {
        RuntimeTypeAdapterFactory<Book> runtimeTypeAdapterFactory = RuntimeTypeAdapterFactory
                .of(Book.class, "type")
                .registerSubtype(Vocabulary.class, "vocabulary")
                .registerSubtype(TextBook.class, "textBook");

        File file = new File(path);
        FileWriter fw = new FileWriter(file);
        fw.write(new GsonBuilder()
                .registerTypeAdapter(Year.class, (JsonSerializer<Year>) (src, typeOfSrc, context) -> new JsonPrimitive(src.getValue()))
                .registerTypeAdapterFactory(runtimeTypeAdapterFactory)
                .create()
                .toJson(library));
        fw.close();
    }

    @Override
    public Library deserialize(String path) throws JAXBException, FileNotFoundException {
        RuntimeTypeAdapterFactory<Book> runtimeTypeAdapterFactory = RuntimeTypeAdapterFactory
                .of(Book.class, "type")
                .registerSubtype(Vocabulary.class, "vocabulary")
                .registerSubtype(TextBook.class, "textBook");

        return new GsonBuilder()
                .registerTypeAdapter(Year.class, (JsonDeserializer<Year>) (json, type, jsonDeserializationContext) -> Year.of(json.getAsJsonPrimitive().getAsInt()))
                .registerTypeAdapterFactory(runtimeTypeAdapterFactory)
                .create()
                .fromJson(new FileReader(path), Library.class);
    }
}
