package com.labs.io;

import com.labs.model.Library;

import javax.xml.bind.JAXBException;
import java.io.FileNotFoundException;
import java.io.IOException;

public interface IO {
    void serialize(Library library, String path) throws JAXBException, IOException;

    Library deserialize(String path) throws JAXBException, FileNotFoundException;
}
