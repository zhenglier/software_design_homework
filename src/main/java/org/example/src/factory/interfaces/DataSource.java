package org.example.src.factory.interfaces;

import org.example.src.factory.observer.DataObserver;

public interface DataSource {
    String getType();
    String readData();
    void writeData(String data);
    
    void addObserver(DataObserver observer);
    void removeObserver(DataObserver observer);
    
    TextReader getReader();
    TextWriter getWriter();
} 