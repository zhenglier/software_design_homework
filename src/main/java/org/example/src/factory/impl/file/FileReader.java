package org.example.src.factory.impl.file;

import org.example.src.factory.interfaces.TextReader;

public class FileReader implements TextReader {
    @Override
    public void read() {
        System.out.println("从文件读取数据");
    }
} 