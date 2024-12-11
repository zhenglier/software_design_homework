package org.example.src.factory.impl.database;

import org.example.src.factory.interfaces.TextReader;

public class DatabaseReader implements TextReader {
    @Override
    public void read() {
        System.out.println("从数据库读取数据");
    }
} 