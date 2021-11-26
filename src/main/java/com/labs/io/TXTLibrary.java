package com.labs.io;

import com.labs.model.Library;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class TXTLibrary {
    public void serialize(Library library, String path) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(path));
        writer.write(library.toString());
        writer.close();
    }
}
