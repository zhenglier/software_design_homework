package org.example.src.factory.impl.database;

import org.example.src.factory.interfaces.TextWriter;

public class DatabaseWriter implements TextWriter {
    @Override
    public void write() {
        System.out.println("写入数据到数据库");
    }
} 