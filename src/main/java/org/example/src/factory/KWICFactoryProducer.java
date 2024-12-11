package org.example.src.factory;

import org.example.src.factory.adapter.FileSystemAdapter;
import org.example.src.factory.adapter.DatabaseAdapter;

public class KWICFactoryProducer {
    public static BasicKWICFactory getFactory(String type) {
        if ("FILE".equalsIgnoreCase(type)) {
            return new BasicKWICFactory(new FileSystemAdapter());
        } else if ("DB".equalsIgnoreCase(type)) {
            return new BasicKWICFactory(new DatabaseAdapter());
        }
        throw new IllegalArgumentException("Unknown factory type: " + type);
    }
}