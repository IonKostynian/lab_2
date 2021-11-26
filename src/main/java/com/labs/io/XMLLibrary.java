package com.labs.io;

import com.labs.model.Library;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public class XMLLibrary implements IO{
    @Override
    public void serialize(Library library, String path) throws JAXBException, IOException {
        JAXBContext jaxbContext = JAXBContext.newInstance(Library.class);
        Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
        jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        jaxbMarshaller.marshal(library, new File(path));
    }

    @Override
    public Library deserialize(String path) throws JAXBException, FileNotFoundException {
        JAXBContext jaxbContext = JAXBContext.newInstance(Library.class);
        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
        Library library = (Library) jaxbUnmarshaller.unmarshal(new File(path));
        return library;
    }
}
