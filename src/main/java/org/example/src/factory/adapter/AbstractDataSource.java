package org.example.src.factory.adapter;

import org.example.src.factory.interfaces.DataSource;
import org.example.src.factory.observer.DataObserver;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractDataSource implements DataSource {
    protected List<DataObserver> observers = new ArrayList<>();

    @Override
    public void addObserver(DataObserver observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(DataObserver observer) {
        observers.remove(observer);
    }

    protected void notifyDataRead(String data) {
        for (DataObserver observer : observers) {
            observer.onDataRead(data);
        }
    }

    protected void notifyDataWrite(String data) {
        for (DataObserver observer : observers) {
            observer.onDataWrite(data);
        }
    }
} 