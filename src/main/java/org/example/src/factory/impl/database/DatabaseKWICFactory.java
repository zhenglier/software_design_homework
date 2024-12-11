package org.example.src.factory.impl.database;

import org.example.src.factory.interfaces.KWICFactory;
import org.example.src.factory.interfaces.TextReader;
import org.example.src.factory.interfaces.TextWriter;

public class DatabaseKWICFactory implements KWICFactory {
    @Override
    public TextReader createReader() {
        return new DatabaseReader();
    }

    @Override
    public TextWriter createWriter() {
        return new DatabaseWriter();
    }
} 