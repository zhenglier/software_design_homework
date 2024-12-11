package org.example.src.factory.impl.file;

import org.example.src.factory.interfaces.KWICFactory;
import org.example.src.factory.interfaces.TextReader;
import org.example.src.factory.interfaces.TextWriter;

public class FileKWICFactory implements KWICFactory {
    @Override
    public TextReader createReader() {
        return new FileReader();
    }

    @Override
    public TextWriter createWriter() {
        return new FileWriter();
    }
} 