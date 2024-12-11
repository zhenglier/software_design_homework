package org.example.src.factory.observer;

public interface DataObserver {
    void onDataRead(String data);
    void onDataWrite(String data);
} 