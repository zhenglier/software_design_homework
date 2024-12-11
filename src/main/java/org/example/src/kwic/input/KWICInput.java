package org.example.src.kwic.input;

import org.example.src.factory.interfaces.TextReader;
import org.example.src.kwic.KWICProcessor;

public class KWICInput {
    private TextReader reader;
    private KWICProcessor processor;

    public KWICInput(TextReader reader, KWICProcessor processor) {
        this.reader = reader;
        this.processor = processor;
    }

    public void processInput(String input) {
        reader.read();
        String[] lines = input.split("\n");
        for (String line : lines) {
            processor.addLine(line.trim());
        }
    }
} 