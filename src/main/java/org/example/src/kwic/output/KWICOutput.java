package org.example.src.kwic.output;

import org.example.src.factory.interfaces.TextWriter;
import org.example.src.kwic.KWICProcessor;

public class KWICOutput {
    private TextWriter writer;
    private KWICProcessor processor;

    public KWICOutput(TextWriter writer, KWICProcessor processor) {
        this.writer = writer;
        this.processor = processor;
    }

    public void writeOutput() {
        for (String line : processor.getShiftedLines()) {
            System.out.println(line);
            writer.write();
        }
    }
} 