package org.example.src.factory;

import org.example.src.factory.impl.file.FileReader;
import org.example.src.factory.impl.file.FileWriter;
import org.example.src.factory.impl.database.DatabaseReader;
import org.example.src.factory.impl.database.DatabaseWriter;
import org.example.src.factory.interfaces.TextReader;
import org.example.src.factory.interfaces.TextWriter;
import org.example.src.factory.adapter.DatabaseAdapter;
import org.example.src.factory.adapter.FileSystemAdapter;
import org.example.src.factory.interfaces.DataSource;

import java.util.HashMap;
import java.util.Map;

public class KWICFactoryProducer {
    private static final Map<FactoryType, Class<? extends TextReader>> readerMap = new HashMap<>();
    private static final Map<FactoryType, Class<? extends TextWriter>> writerMap = new HashMap<>();

    static {
        // 注册实现类
        registerReader(FactoryType.FILE, FileReader.class);
        registerReader(FactoryType.DATABASE, DatabaseReader.class);
        registerWriter(FactoryType.FILE, FileWriter.class);
        registerWriter(FactoryType.DATABASE, DatabaseWriter.class);
    }

    public static void registerReader(FactoryType type, Class<? extends TextReader> readerClass) {
        readerMap.put(type, readerClass);
    }

    public static void registerWriter(FactoryType type, Class<? extends TextWriter> writerClass) {
        writerMap.put(type, writerClass);
    }

    public static TextReader createReader(FactoryType type) {
        try {
            Class<? extends TextReader> readerClass = readerMap.get(type);
            if (readerClass == null) {
                throw new IllegalArgumentException("Unsupported factory type");
            }
            return readerClass.getDeclaredConstructor().newInstance();
        } catch (Exception e) {
            throw new RuntimeException("Failed to create reader", e);
        }
    }

    public static TextWriter createWriter(FactoryType type) {
        try {
            Class<? extends TextWriter> writerClass = writerMap.get(type);
            if (writerClass == null) {
                throw new IllegalArgumentException("Unsupported factory type");
            }
            return writerClass.getDeclaredConstructor().newInstance();
        } catch (Exception e) {
            throw new RuntimeException("Failed to create writer", e);
        }
    }

    public static DataSource createDataSource(FactoryType type) {
        TextReader reader = createReader(type);
        TextWriter writer = createWriter(type);
        
        switch (type) {
            case FILE:
                return new FileSystemAdapter(reader, writer);
            case DATABASE:
                return new DatabaseAdapter(reader, writer);
            default:
                throw new IllegalArgumentException("Unsupported factory type");
        }
    }
} 