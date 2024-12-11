package org.example.src.factory.impl.file;

import org.example.src.factory.interfaces.TextWriter;

public class FileWriter implements TextWriter {
    @Override
    public void write() {
        System.out.println("写入数据到文件");
    }
} 